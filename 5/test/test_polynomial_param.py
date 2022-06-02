import Polynomial as Polynomial
import pytest

TERMS_LIST = [
    [[4, 3], [-2, 1]],
    [[-4, 3], [-2, 1]]
]


INVALID_TERMS_LIST = [
  [[4, -3], [-2, 1]],
  [[-4, 1.5], [-2, 1]]
]


@pytest.fixture(params=TERMS_LIST)
def poly(request):
    return Polynomial(request.param)


def test_exponents(poly):
    exponents = [term[1] for term in poly.terms]
    valid_exponents = map(lambda x: x == int(x) and x >= 0, exponents)
    assert all(valid_exponents)


def test_derivative_exponents(poly):
    exponents = [term[1] for term in poly.derivative().terms]
    valid_exponents = map(lambda x: x == int(x) and x >= 0, exponents)
    assert all(valid_exponents)


def test_str_leading_minus(poly):
    if len(poly.terms) == 0:
        first_term = 0
    else:
        first_term = poly.terms[0][0]
    assert first_term >= 0 or str(poly).startswith('-')


INVALID_TERMS_LIST = [
  [[4, -3], [-2, 1]],
  [[-4, 1.5], [-2, 1]]
]


@pytest.mark.parametrize('invalid_terms', INVALID_TERMS_LIST)
def test_args_fail(invalid_terms):
    with pytest.raises(AssertionError):
        Polynomial(invalid_terms)