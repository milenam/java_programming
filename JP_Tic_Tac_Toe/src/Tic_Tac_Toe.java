import java.util.*; 

import javax.swing.*;

public class Tic_Tac_Toe {

	public static void main(String[] args) {
		int[] board = new int[]{1,2,3,4,5,6,7,8,9};
		String pos;
		String t1 = "0";
		String t2 = "0";
		char u = 'X';
		char c = 'O';
		int x = Integer.parseInt(t1);
		int o = Integer.parseInt(t2);
		
		StringBuilder sb = new StringBuilder();
		JLabel l = new JLabel("<html>Welcome to Tic Tac Toe Game<br>You will have X and computer will have O</html>", SwingConstants.CENTER);
		int dialog = JOptionPane.showConfirmDialog(null, l);
		createBoard(board, sb);
		
		//System.out.println(sb.getClass());
		
		if(dialog == JOptionPane.OK_OPTION){
			JLabel b = new JLabel("<html>Enter the position where you want to play<br>" + sb.toString() + "</html>", SwingConstants.CENTER);
			pos = JOptionPane.showInputDialog(null, b);
			int index = Integer.parseInt(pos);
			//for (int i = 0; i < board.length; i++) {
			//	board[i][index] = x;
			//}
			//createBoard(board, sb);
			//System.out.println(sb.toString());
			board[index-1] = x;
			System.out.println(Arrays.toString(board));
			StringBuilder sb2 = updateBoard(board, sb, u, c, index);
			System.out.println(sb2);
			JLabel n = new JLabel("<html>Your move is recorded, now computer will play" + sb2 + "</html>", SwingConstants.CENTER);
			int dialog2 = JOptionPane.showConfirmDialog(null, n);
		}
	
    }
	
	public static void createBoard(int[] board, StringBuilder sb) {
		for (int i = 0; i < board.length; i++) {
			//sb.append("<br/>");
			//for (int j = 0; j < board[i].length; j++) {
				if (i%3 == 0) {
					sb.append("<br/>");
				}
				sb.append(board[i]);
			//}
		}
	}

	public static StringBuilder updateBoard(int[] board, StringBuilder sb, char u, char c, int index) {
		//System.out.println(sb.toString().replace((char) (index-1), u));
		sb.toString().replaceFirst("2","X");
		return sb;
	}
	
}