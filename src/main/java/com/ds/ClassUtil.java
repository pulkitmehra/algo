package com.ds;

public class ClassUtil {

	public static class TwDPt {
		public int y;
		public int x;
		public int v;

		public static TwDPt get(int y, int x) {
			TwDPt pt = new TwDPt();
			pt.y = y;
			pt.x = x;
			return pt;
		}

		public static TwDPt get(int y, int x, int v) {
			TwDPt pt = new TwDPt();
			pt.y = y;
			pt.x = x;
			pt.v=v;
			return pt;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TwDPt other = (TwDPt) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[" + y + "," + x + "]";
		}

	}

}
