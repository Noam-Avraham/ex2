#!/bin/sh
# Run the structural stress-test suite (statement-list nesting combinations).
# Must be run from ex2/ after `make` has produced the PARSER jar, with this
# stress_tests/ directory placed as a sibling (pass its path as $1, or run
# from inside ex2_test_scaffolding/ with ex2/PARSER on a relative path).
set -e
SCRIPT_DIR="$(dirname "$0")"
EX2_DIR="${1:-../../ex2}"

mkdir -p "$SCRIPT_DIR/output"
pass=0
fail=0
for f in "$SCRIPT_DIR"/input/*.txt; do
    base=$(basename "$f" .txt)
    out="$SCRIPT_DIR/output/${base}_out.txt"
    java -jar "$EX2_DIR/PARSER" "$f" "$out"
    if cmp -s "$out" "$SCRIPT_DIR/expected_output/${base}_Expected_Output.txt"; then
        echo "PASS: $base"
        pass=$((pass+1))
    else
        echo "FAIL: $base"
        fail=$((fail+1))
    fi
done
echo "=== $pass passed, $fail failed ==="
[ "$fail" -eq 0 ]
