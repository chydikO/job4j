package ru.job4j.array;

class MatrixCheck {

    /**
     *  Check array
     * @param data input array
     * @return isDiagonal - true/false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[1][1] != data[i][i] || data[1][1] != data[data.length - 1 - i][i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
