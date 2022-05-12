import utils.algo
import pytest

@pytest.fixture
def data():

    return [3, 2, 1, 5, -3, 2, 0, -2, 11, 9]

def test_sel_sort(data):

    sorted_vals = utils.algo.sel_sort(data)
    assert sorted_vals == sorted(data)

def test_min():
    values = (2, 3, 1, 4, 6)

    val = utils.algo.min(values)
    assert val == 1

def test_max():
    values = (2, 3, 1, 4, 6)

    val = utils.algo.max(values)
    assert val == 6