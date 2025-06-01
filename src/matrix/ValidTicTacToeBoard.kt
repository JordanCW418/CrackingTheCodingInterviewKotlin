package matrix
// https://leetcode.com/problems/valid-tic-tac-toe-state/description/
// 108 / 111 testcases passed

    fun validTicTacToe(board: Array<String>): Boolean {
        val boardBalance = getBalance(board)
        if(boardBalance !in 0..1) {
            return false
        }

        val wins = checkWins(board)
        if((wins.first > 0 && wins.second > 0) ||
            wins.first > 1 ||
            wins.second > 1) {
            return false
        }
        if (wins.first > 0 && boardBalance != 1) return false
        if (wins.second > 0 && boardBalance != 0) return false

        return true
    }

    private fun getBalance(board: Array<String>): Int {
        var balance = 0
        for(i in 0..2) {
            for(j in 0..2) {
                val current = accessBoard(board, i, j)
                if(current == 'X') {
                    balance++
                } else if (current == 'O') {
                    balance--
                }
            }
        }
        return balance
    }

    private fun checkWins(board: Array<String>): Pair<Int, Int> {
        var xWins = 0
        var oWins = 0
        var xCount3 = 0
        var oCount3 = 0
        var xCount4 = 0
        var oCount4 = 0
        for(i in 0..2) {
            //Check for diagonal Wins
            val current3 = accessBoard(board, i, i)
            val current4 = accessBoard(board, 2 - i, i)
            if(current3 == 'X') {
                xCount3++
            } else if (current3 == 'O') {
                oCount3++
            }
            if(current4 == 'X') {
                xCount4++
            } else if (current4 == 'O') {
                oCount4++
            }

            var xCount1 = 0
            var oCount1 = 0
            var xCount2 = 0
            var oCount2 = 0
            for(j in 0..2) {
                val current1 = accessBoard(board, i, j)
                if(current1 == 'X') {
                    xCount1++
                } else if (current1 == 'O') {
                    oCount1++
                }
                val current2 = accessBoard(board, j, i)
                if(current2 == 'X') {
                    xCount2++
                } else if (current2 == 'O') {
                    oCount2++
                }
            }

            if(xCount1 == 3) {
                xWins++
            }
            if(oCount1 == 3) {
                oWins++
            }

            if(xCount2 == 3) {
                xWins++
            }
            if(oCount2 == 3) {
                oWins++
            }
        }

        if(xCount3 == 3) {
            xWins++
        }
        if(oCount3 == 3) {
            oWins++
        }

        if(xCount4 == 3) {
            xWins++
        }
        if(oCount4 == 3) {
            oWins++
        }
        return Pair(xWins, oWins)
    }

    private fun accessBoard(board: Array<String>, x: Int, y: Int): Char {
        return board[y][x]
    }