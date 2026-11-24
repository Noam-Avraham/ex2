#!/bin/sh
# Run the custom edge-case regression suite (see README.md).
# Must be run from ex2/ after `make` has produced the PARSER jar.
set -e
cd "$(dirname "$0")/.."

mkdir -p my_tests/output
pass=0
fail=0
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
echo "=== $pass passed, $fail failed ==="
[ "$fail" -eq 0 ]
