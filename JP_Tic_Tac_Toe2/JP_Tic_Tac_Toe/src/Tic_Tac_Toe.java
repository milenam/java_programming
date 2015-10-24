import java.util.*; 

import javax.swing.*;

public class Tic_Tac_Toe {

	public static void main(String[] args) {
		int[][] board = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		String pos = null;
		boolean user = false;
		boolean comp = false;
		int counter = 0;
		
		ArrayList sb = new ArrayList();
		StringBuilder tboard = new StringBuilder();
		JLabel l = new JLabel("<html>Welcome to Tic Tac Toe Game<br>You will have X and computer will have O</html>", SwingConstants.CENTER);
		int dialog = JOptionPane.showConfirmDialog(null, l);
		createBoard(board, sb, tboard);
		recursive(dialog, pos, tboard, sb, user, comp, board, counter);	
    }
	
	public static void createBoard(int[][] board, ArrayList sb, StringBuilder tboard) {
		for (int i = 0; i < board.length; i++) {
			tboard.append("<br/>");
			for (int j = 0; j < board.length; j++) {
				sb.add(board[i][j]);
//				if (i%3 == 0) {
//					tboard.append("<br/>");
//				}
				tboard.append(" " + board[i][j] + " ");
			}
		}
	}
	
	public static boolean isTaken(ArrayList sb, int rand) {
		if ((sb.get(rand-1) == "X") || (sb.get(rand-1) == "O")) {
			return false;
		} else {
		   return true;	
		}
	}
	
	public static boolean isOneInColumnLeft(ArrayList sb, int[][] board, int counter) {
		//int temp;
		int temp2;
		for (int i = 1; i <= board.length; i++) {
			for (int j = 1; j <= board[i].length; j++) {
				System.out.println("cell" + sb.get(board[i][j]));
				if (sb.get(board[i][j]) == "X") {
					
					counter++;
					System.out.println("counter" + counter);
					return false;
//					if (counter == 2) {
//						for (int j2 = 1; j2 < 4; j2++) {
//							if(isTaken(sb, j2) == true) {
//								temp2 = board[i][j2];
//								sb.set(temp2, "O");
//								return false;
//							} 
//						}
//					}
				} else {
					return true;
				}
		    }
		}
		return false;
	}

	public static StringBuilder updateBoard(int[][] board, ArrayList sb, int index, boolean user, boolean comp, int counter) {
		int in = sb.indexOf(index);
		if (user) {
		  sb.set(in,"X");
		  
		} else if (comp) {
			int rand;
			while (true) {
				//System.out.println("begin local" + localCount);
				//if (localCount == 9) {
				//	break;
				//}
				rand = randInt(1, sb.size());
				System.out.println("rand" + rand);
				if (isTaken(sb, rand) == true) {
				  sb.set(rand-1, "O");
				  break;
				
				} else {
					continue;
				}
			}
		}
		System.out.println(sb);
	    StringBuilder boardToString = new StringBuilder();
		for (int i = 0; i < sb.size(); i++) {
			if (i%3 == 0) {
				boardToString.append("<br/>");
			}
		   boardToString.append(" " + sb.get(i) + " ");
	    }
		return boardToString;
	}
	
	
	public static int randInt(int min, int max) {
	    int randomNum = min + (int)(Math.random() * ((max - min) + 1));
	    return randomNum;
	}
	
	public static void recursive(int dialog, String pos, StringBuilder tboard, ArrayList sb, boolean user, boolean comp, int[][] board, int counter) {
		if(dialog == JOptionPane.OK_OPTION){
			JLabel b = new JLabel("<html>Enter the position where you want to play<br>" + tboard + "</html>", SwingConstants.CENTER);
			pos = JOptionPane.showInputDialog(null, b);
			int index = Integer.parseInt(pos);
			StringBuilder newBoard = updateBoard(board, sb, index, user=true, comp=false, counter);
			JLabel n = new JLabel("<html>Your move is recorded, now computer will play" + newBoard + "</html>", SwingConstants.CENTER);
			int dialog2 = JOptionPane.showConfirmDialog(null, n);
			newBoard = updateBoard(board, sb, index, user=false, comp=true, counter);
			JLabel m = new JLabel("<html>Computer has played" + newBoard + "</html>", SwingConstants.CENTER);
			int dialog3 = JOptionPane.showConfirmDialog(null, m);
			if (isOneInColumnLeft(sb, board, counter) == false) {
		      System.out.println("comp won!");
			} else {
			  recursive(dialog, pos, newBoard, sb, user, comp, board, counter);
			}
		}
	}
}