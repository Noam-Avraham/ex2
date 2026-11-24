#!/bin/sh
# Run all 10 official tests in input/ against expected_output/, after `make`.
set -e
cd "$(dirname "$0")"

mkdir -p output
pass=0
fail=0
for f in input/TEST_*.txt; do
    base=$(basename "$f" .txt)
    out="output/${base}_out.txt"
    expected="expected_output/${base}_Expected_Output.txt"
    java -jar PARSER "$f" "$out"
    if cmp -s "$out" "$expected"; then
        echo "PASS: $base"
        pass=$((pass+1))
    else
        echo "FAIL: $base"
        fail=$((fail+1))
    fi
done
echo "=== $pass passed, $fail failed ==="
[ "$fail" -eq 0 ]
