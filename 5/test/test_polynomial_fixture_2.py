import Polynomial as Polynomial
import pytest


@pytest.fixture()
def poly1():
    return Polynomial([[4, 3], [-2, 1]])


def test_str_leading_minus(poly1):
    if len(poly.terms) == 0:
        first_term = 0
    else:
        first_term = poly.terms[0][0]
    assert first_term >= 0 or str(poly).startswith('-')


@pytest.fixture()
def poly2():
    return Polynomial([[-4, 3], [-2, 1]])


def test_str_leading_minus(poly2):
    if len(poly.terms) == 0:
        first_term = 0
    else:
        first_term = poly.terms[0][0]
    assert first_term >= 0 or str(poly).startswith('-')