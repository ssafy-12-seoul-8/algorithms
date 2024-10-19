import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String msg = br.readLine();
		int ol = msg.length();
		msg = msg.replace(":-)", "");
		int hl = msg.length();
		msg = msg.replace(":-(", "");
		int sl = msg.length();

		sl = (hl - sl);
		hl = (ol - hl);

		if (hl == 0 && sl == 0) {
			System.out.println("none");
		} else if (hl == sl) {
			System.out.println("unsure");
		} else if (hl > sl) {
			System.out.println("happy");
		} else {
			System.out.println("sad");
		}

	}

}