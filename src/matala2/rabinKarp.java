package matala2;

public class rabinKarp {
	public final static int d = 256;

	static void rabinKarp(String pat, String txt, int q, boolean print) {
		int M = pat.length();
		int N = txt.length();
		int count = 0;
		int i, j;
		int p = 0;
		int t = 0;
		int h = 1;

		for (i = 0; i < M - 1; i++)
			h = (h * d) % q;

		for (i = 0; i < M; i++) {

			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		for (i = 0; i <= N - M; i++) {

			if (p == t) {
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				if (j == M) {
					if(print)
					System.out.println(pat + " found at index " + i);
					count++;
				}
			}

			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

				if (t < 0)
					t = (t + q);
			}
		}
		if (count != 0)
			System.out.println(pat + " appeared " + count + " times");
	}
}
