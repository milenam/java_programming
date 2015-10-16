import java.util.*; 

import javax.swing.*;

public class Tic_Tac_Toe {

	public static void main(String[] args) {
		int[] board = new int[]{1,2,3,4,5,6,7,8,9};
		String pos = null;
		boolean user = false;
		boolean comp = false;
		
		ArrayList sb = new ArrayList();
		StringBuilder tboard = new StringBuilder();
		JLabel l = new JLabel("<html>Welcome to Tic Tac Toe Game<br>You will have X and computer will have O</html>", SwingConstants.CENTER);
		int dialog = JOptionPane.showConfirmDialog(null, l);
		createBoard(board, sb, tboard);
		
		//System.out.println(sb.getClass());
		recursive(dialog, pos, tboard, sb, user, comp, board);
		
//		if(dialog == JOptionPane.OK_OPTION){
//			JLabel b = new JLabel("<html>Enter the position where you want to play<br>" + tboard + "</html>", SwingConstants.CENTER);
//			pos = JOptionPane.showInputDialog(null, b);
//			int index = Integer.parseInt(pos);
//			//board[index-1] = x;
//			//System.out.println(Arrays.toString(board));
//			StringBuilder newBoard = updateBoard(board, sb, u, c, index, user=true, comp=false);
//			JLabel n = new JLabel("<html>Your move is recorded, now computer will play" + newBoard + "</html>", SwingConstants.CENTER);
//			int dialog2 = JOptionPane.showConfirmDialog(null, n);
////			sb2 = compMove(board, sb2, u, c, index);
//			newBoard = updateBoard(board, sb, u, c, index, user=false, comp=true);
//			JLabel m = new JLabel("<html>Computer has played" + newBoard + "</html>", SwingConstants.CENTER);
//			int dialog3 = JOptionPane.showConfirmDialog(null, m);
//		}
	
    }
	
	public static void createBoard(int[] board, ArrayList sb, StringBuilder tboard) {
		for (int i = 0; i < board.length; i++) {
				sb.add(board[i]);
				if (i%3 == 0) {
					tboard.append("<br/>");
				}
				tboard.append(" " + board[i] + " ");

		}
	}

	public static StringBuilder updateBoard(int[] board, ArrayList sb, int index, boolean user, boolean comp) {
//		String indexToString = String.valueOf(index);
//		int in = sb.indexOf(indexToString);
//		sb.replace(in, in+1, "X");
//		System.out.println(sb);
		int in = sb.indexOf(index);
		if (user) {
		  sb.set(in,"X");
		} else if (comp) {
			int rand = randInt(0, sb.size());
			if(sb.get(rand) != "X") {
				sb.set(rand, "O");
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
	
	public static void recursive(int dialog, String pos, StringBuilder tboard, ArrayList sb, boolean user, boolean comp, int[] board) {
		if(dialog == JOptionPane.OK_OPTION){
			JLabel b = new JLabel("<html>Enter the position where you want to play<br>" + tboard + "</html>", SwingConstants.CENTER);
			pos = JOptionPane.showInputDialog(null, b);
			int index = Integer.parseInt(pos);
			StringBuilder newBoard = updateBoard(board, sb, index, user=true, comp=false);
			JLabel n = new JLabel("<html>Your move is recorded, now computer will play" + newBoard + "</html>", SwingConstants.CENTER);
			int dialog2 = JOptionPane.showConfirmDialog(null, n);
			newBoard = updateBoard(board, sb, index, user=false, comp=true);
			JLabel m = new JLabel("<html>Computer has played" + newBoard + "</html>", SwingConstants.CENTER);
			int dialog3 = JOptionPane.showConfirmDialog(null, m);
			recursive(dialog, pos, newBoard, sb, user, comp, board);
		}
	}
}