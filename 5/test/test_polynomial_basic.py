import Polynomial as Polynomial
import pytest


def test_exponents():
    poly = Polynomial([[4, 3], [-2, 1]])
    exponents = [term[1] for term in poly.terms]
    valid_exponents = map(lambda x: x == int(x) and x >= 0, exponents)
    assert all(valid_exponents)


def test_derivative_exponents():
    poly = Polynomial([[4, 3], [-2, 1]])
    exponents = [term[1] for term in poly.derivative().terms]
    valid_exponents = map(lambda x: x == int(x) and x >= 0, exponents)
    assert all(valid_exponents)


def test_str_leading_minus():
    poly = Polynomial([[4, 3], [-2, 1]])
    if len(poly.terms) == 0:
        first_term = 0
    else:
        first_term = poly.terms[0][0]
    assert first_term >= 0 or str(poly).startswith('-')