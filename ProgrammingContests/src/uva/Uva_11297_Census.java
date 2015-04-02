package uva;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class Uva_11297_Census {
	public static int matrix[][];
	public static int r[] = new int[4], mins[] ,maxs[];
	public static boolean flag;
	public static int max( int a, int b) { if ( a > b) return a; return b;}
	public static int min( int a, int b) { if ( a < b) return a; return b;}
	static class Node
	{
		int max, min, startW, endW, startH, endH;
		Node upLeft, upRight, downLeft, downRight;
		public Node( int iw, int fw, int ih, int fh)
		{
			startW = iw;
			endW = fw;
			startH = ih;
			endH = fh;
			if ( iw == fw && ih == fh )
			{
				max = matrix[ih][iw];
				min = matrix[ih][iw];;
			}
			else if ( iw == fw )
			{
				upLeft = new Node(iw, fw, ih, (fh+ih)/2);
				downLeft = new Node(iw, fw, 1+(fh+ih)/2, fh);
				max = max(upLeft.max, downLeft.max);
				min = min(upLeft.min, downLeft.min);
			}
			else if ( ih == fh )
			{
				upLeft = new Node(iw, (fw+iw)/2, ih, fh);
				upRight = new Node(1+(iw+fw)/2, fw, ih, fh);
				max = max(upLeft.max, upRight.max);
				min = min(upLeft.min, upRight.min);
			}
			else
			{
				upLeft = new Node(iw, (iw+fw)/2, ih, (ih+fh)/2);
				upRight = new Node(1+(iw+fw)/2, fw, ih, (ih+fh)/2);
				downLeft = new Node(iw, (iw+fw)/2, 1+(ih+fh)/2, fh);
				downRight = new Node(1+(iw+fw)/2, fw, 1+(ih+fh)/2, fh);
				max = max(max(upLeft.max, upRight.max), max(downLeft.max, downRight.max));
				min = min(min(upLeft.min, upRight.min), min(downLeft.min, downRight.min));
			}
		}
		public boolean contains( int row, int column)
		{
			if ( startW <= column && endW >= column && startH <= row && endH >= row) return true;
			return false;
		}
		public void set( int row, int column, int v)
		{
			mins = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
			maxs = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
			if ( upLeft != null && upLeft.contains(row, column) )  { upLeft.set(row, column, v); } 
			else if ( upRight != null && upRight.contains(row, column) ) { upRight.set(row, column, v); } 
			else if ( downLeft != null && downLeft.contains(row, column) ) { downLeft.set(row, column, v); }
			else if ( downRight != null && downRight.contains(row, column) ) { downRight.set(row, column, v); }
			
			if(startW == endW && startH == endH){ min = v; max = v; return; }
			if ( upLeft != null )
			{
				mins[0] = upLeft.min; 
				maxs[0] = upLeft.max;
			}
			if ( upRight != null )
			{
				mins[1] = upRight.min;
				maxs[1] = upRight.max;
			}
			if ( downLeft != null )
			{
				mins[2] = downLeft.min;
				maxs[2] = downLeft.max;
			}
			if ( downRight != null )
			{
				mins[3] = downRight.min;
				maxs[3] = downRight.max;
			}	
			min = min(min(mins[0], mins[1]), min(mins[2], mins[3]));
			max = max(max(maxs[0], maxs[1]), max(maxs[2], maxs[3]));
			
		}
		public void intersection( int iw, int fw, int ih, int  fh)
		{
			flag = true;
			r[0] = max(startW, iw);
			r[1] = min(endW, fw);
			if ( r[0] > r[1]) { flag = false; return; }
			r[2] = max(startH, ih);
			r[3] = min(endH, fh);
			if ( r[2] > r[3] ) flag = false;
		}
		public int[] gr()
		{
			return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
		}
		public int[] query( int iw, int fw, int ih, int fh)
		{
			int range[] = new int[2];
			if ( iw == startW && fw == endW && ih == startH && fh == endH) 
			{
				range[0] = min;
				range[1] = max;
				return range;
			}
			int r1[] = gr(), r2[] = gr(), r3[] = gr(), r4[] = gr();
			if ( upLeft != null)
			{
				upLeft.intersection(iw, fw, ih, fh);
				if ( flag )  r1 = upLeft.query(r[0], r[1], r[2], r[3]);	
			}
			if ( upRight != null)
			{
				upRight.intersection(iw, fw, ih, fh);
				if ( flag ) r2 = upRight.query(r[0], r[1], r[2], r[3]);
			}
			if ( downLeft != null )
			{
				downLeft.intersection(iw, fw, ih, fh);
				if ( flag ) r3 = downLeft.query(r[0], r[1], r[2], r[3]);
			}
			if ( downRight != null )
			{
				downRight.intersection(iw, fw, ih, fh);
				if ( flag ) r4 = downRight.query(r[0], r[1], r[2], r[3]);
			}
			range[0] = min(min(r1[0], r2[0]), min(r3[0], r4[0])); 
			range[1] = max(max(r1[1], r2[1]),max(r3[1],r4[1]));
			return range;
		}
		
	}
	public static int[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		int rr[] = new int[n];
		for (int i = 0; i < n; i++) {
			rr[i] = Integer.parseInt(lines[i]);
		}
		return rr;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in;
		StringBuilder out = new StringBuilder();
		File file = new File("in");
		if (file.exists())
			in = new BufferedReader(new FileReader(file));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		String line, lines[];
		int rows, columns, q, x1, y1, x2, y2, res[];
		Node root;
		while ((line = in.readLine()) != null) {
			lines = line.split("\\s+");
			rows = Integer.parseInt(lines[0]);
			columns = Integer.parseInt(lines[1]);
			matrix = new int[rows][columns];
			for ( int i = 0; i < rows; i++ )
			{
				matrix[i] = parseInts(in.readLine());
			}
			root = new Node(0, columns-1, 0, rows-1);
			q = Integer.parseInt(in.readLine());
			for ( int i = 0; i < q; i++ )
			{
				lines = in.readLine().split(" ");
				if ( lines[0].equals("q"))
				{
					x1 = Integer.parseInt(lines[1])-1;
					y1 = Integer.parseInt(lines[2])-1;
					x2 = Integer.parseInt(lines[3])-1;
					y2 = Integer.parseInt(lines[4])-1;
					res = root.query(y1, y2, x1, x2);
					out.append(res[1]+" "+res[0]+"\n");
				}
				else
				{
					root.set(Integer.parseInt(lines[1])-1, Integer.parseInt(lines[2])-1, Integer.parseInt(lines[3]));
				}
			}
		}
		System.out.print(out);
	}
}
