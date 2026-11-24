# my_tests/ — custom edge-case regression suite

These are hand-written tests covering grammar corners the 10 official
`input/` tests don't exercise directly. They are NOT part of the official
submission/grading — kept separately so they never interfere with the
official self-check's own `tests/` folder or `expected_output/` naming.

Each test's expected classification was verified by hand against the
grammar (`cup/CUP_FILE.cup`) and the spec's EBNF (Table 2), not just
"didn't crash":

| Test | Exercises | Expected |
|---|---|---|
| 01_empty_body_rejected | `stmtList ::= stmt { stmt }` requires >=1 stmt | `ERROR(3)` |
| 02_dangling_else_last | `if` with no `else`, last stmt in block | `OK` |
| 03_open_if_followed_by_stmt | open `if` followed by more statements (the TEST_01 regression) | `OK` |
| 04_else_ends_in_open_if | `if/else` where the else-branch itself ends in an unresolved `if` | `OK` |
| 05_else_if_chain | chained `else { if ... }` | `OK` |
| 06_operator_precedence | full operator precedence/associativity chain; hand-verified tree shape | `OK` |
| 07_unary_minus | `MINUS INT` literal | `OK` |
| 08_array_subscript_chain | `arrayTypedef` + chained `var[exp]` | `OK` |
| 09_class_extends_mixed_fields | `classDec` with `EXTENDS` + both var/func `cfield`s | `OK` |
| 10_newexp_object_and_array | both `newExp` forms (object vs sized array) | `OK` |
| 11_call_variants | call with/without receiver, with/without args | `OK` |
| 12_return_variants | `return;` and `return exp;` | `OK` |
| 13_string_and_nil | `STRING` and `NIL` literal exps | `OK` |
| 14_lexical_error_leading_zero | `0[0-9]+` lexer rule | bare `ERROR` |
| 15_lexical_error_big_integer | out-of-range integer lexer rule | bare `ERROR` |
| 16_lexical_error_bad_string | string containing a digit | bare `ERROR` |
| 17_lexical_error_illegal_char | `@` matches no rule | bare `ERROR` |
| 18_lexical_error_unterminated_comment | `/*` with no matching `*/` before EOF | bare `ERROR` |
| 19_syntax_error_missing_semicolon | missing `;` after a `varDec` | `ERROR(4)` |
| 20_syntax_error_missing_brace | missing closing `}` before EOF | `ERROR(5)` |

## Running on nova

From the `ex2/` directory, after `make` has produced the `PARSER` jar:

```sh
mkdir -p my_tests/output
pass=0; fail=0
for f in my_tests/input/*.txt; do
    base=$(basename "$f" .txt)
    out="my_tests/output/${base}_out.txt"
    java -jar PARSER "$f" "$out"
    if cmp -s "$out" "my_tests/expected_output/${base}_Expected_Output.txt"; then
        echo "PASS: $base"
        pass=$((pass+1))
    else
        echo "FAIL: $base"
        fail=$((fail+1))
    fi
done
echo "$pass passed, $fail failed"
```

Or just run `./my_tests/run_tests.sh` after `make`.
