package com.appium.anums;

public enum Times {
	ONE {
		public int getValue() {
			return 1;
		}
	},
	TWO {
		public int getValue() {
			return 2;
		}
	},
	THREE {
		public int getValue() {
			return 3;
		}

	},
	FOUR {
		public int getValue() {
			return 4;
		}

	};
	public abstract int getValue();
}
