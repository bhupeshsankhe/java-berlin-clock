package com.ubs.opsit.interviews;

public class BerlinTimeConvertor implements TimeConverter {
	
	/**
	 * Line separator in output format
	 */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private static final String DEFAULT_LAMP_STATUS = "OOOO";
	private static final String DEFAULT_LAMP_STATUS_MINUTES_FIRST_ROW = "OOOOOOOOOOO";
	
	/**
	 * Enum to different lamp colors
	 * 
	 * @author Bhupesh Sankhe
	 *
	 */
	public enum Lights{
		
		RED("R"), YELLOW("Y"), NOLIGHT("O");
		
		private Lights(String lightSymbol){
			this.lightSymbol = lightSymbol;
		}
		
		public String getLightSymbol() {
			return lightSymbol;
		}

		private String lightSymbol;
	}
	
	/**
	 * Enum for Hours and Minutes. 
	 * The enum also holds lamps in each rows and colors for hours and minutes
	 * 
	 * @author Bhupesh Sankhe
	 *
	 */
	public enum EncodeTime{
		
		HOURS(Lights.RED, 4, 4, 5), MINUTES(Lights.YELLOW, 11, 4, 5);
		
		private EncodeTime(Lights light, int lampsInFirstRow, int lampsInSecondRow, int multiplier){
			
			this.light = light;
			this.lampsInFirstRow = lampsInFirstRow;
			this.lampsInSecondRow = lampsInSecondRow;
			this.multiplier = multiplier;
		}
		
		public Lights getLight() {
			return light;
		}
		public int getLampsInFirstRow() {
			return lampsInFirstRow;
		}
		public int getLampsInSecondRow() {
			return lampsInSecondRow;
		}
		public int getMultiplier() {
			return multiplier;
		}

		private Lights light;
		private int lampsInFirstRow;
		private int lampsInSecondRow;
		private int multiplier;
	}

	/**
	 * 
	 * Method to convert time.
	 * 
	 * @param String
	 * @author Bhupesh Sankhe
	 */
	@Override
	public String convertTime(String aTime) {
		
		// Split time
		
		String time[] = aTime.split(":");
		
		int hours = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		int seconds = Integer.parseInt(time[2]);
		
		StringBuffer timeEncodingHolder = new StringBuffer();
		
		// Encode Seconds
		encodeSeconds(timeEncodingHolder, seconds);
		
		// Encode Hours
		encodeHours(timeEncodingHolder, hours);
		
		// Encode Minutes
		encodeMinutes(timeEncodingHolder, minutes);
				
		return timeEncodingHolder.toString();
	}
	
	/**
	 * 
	 * Method to encode seconds in Berlin lamps format
	 * 
	 * @param timeEncodingHolder
	 * @param seconds
	 * 
	 * @author Bhupesh Sankhe
	 */
	private void encodeSeconds(StringBuffer timeEncodingHolder, int seconds){
		
		if(seconds % 2 == 0){
			timeEncodingHolder.append("Y").append(LINE_SEPARATOR);
		}
		else {
			timeEncodingHolder.append("O").append(LINE_SEPARATOR);
		}
	}
	
	/**
	 * Method to encode minutes in Berlin lamps format
	 * 
	 * @param timeEncodingHolder
	 * @param minutes
	 * 
	 * @author Bhupesh Sankhe
	 * 
	 */
	private void encodeMinutes(StringBuffer timeEncodingHolder, int minutes){
		
		if(minutes == 0) {
			timeEncodingHolder.append(DEFAULT_LAMP_STATUS_MINUTES_FIRST_ROW).append(LINE_SEPARATOR).append(DEFAULT_LAMP_STATUS);
			return;
		}
		
		int multiplier = EncodeTime.MINUTES.getMultiplier();
		int minFirstRow = ( minutes / multiplier );
		int minSecondRow = ( minutes % multiplier );
		
		encode(timeEncodingHolder, minFirstRow, EncodeTime.MINUTES.getLampsInFirstRow(), EncodeTime.MINUTES.getLight(), true);
		timeEncodingHolder.append(LINE_SEPARATOR);
		encode(timeEncodingHolder, minSecondRow, EncodeTime.MINUTES.getLampsInSecondRow(), EncodeTime.MINUTES.getLight(), false);
		
	}
	
	/**
	 * Method to encode hours in Berlin lamps format
	 * 
	 * @param timeEncodingHolder
	 * @param hours
	 * 
	 * @author Bhupesh Sankhe
	 */
	private void encodeHours(StringBuffer timeEncodingHolder, int hours){
		
		if(hours == 0) {
			timeEncodingHolder.append(DEFAULT_LAMP_STATUS).append(LINE_SEPARATOR).append(DEFAULT_LAMP_STATUS).append(LINE_SEPARATOR);
			return;
		}
		
		int multiplier = EncodeTime.HOURS.getMultiplier();
		int hrsFirstRow = ( hours / multiplier );
		int hrsSecondRow = ( hours % multiplier );
		
		encode(timeEncodingHolder, hrsFirstRow, EncodeTime.HOURS.getLampsInFirstRow(), EncodeTime.HOURS.getLight(), false);
		timeEncodingHolder.append(LINE_SEPARATOR);
		encode(timeEncodingHolder, hrsSecondRow, EncodeTime.HOURS.getLampsInSecondRow(), EncodeTime.HOURS.getLight(), false);
		timeEncodingHolder.append(LINE_SEPARATOR);
	}
	
	/**
	 * Generic Method to get the Berlin lamps status
	 * 
	 * @param timeEncodingHolder
	 * @param loopNumber
	 * @param numberOfLamps
	 * @param light
	 * @param isQuarterSignEnabled
	 * 
	 * @author Bhupesh Sankhe
	 */
	
	private void encode(StringBuffer timeEncodingHolder, int loopNumber, 
						int numberOfLamps, Lights light, boolean isQuarterSignEnabled){
		
		for(int i = 1; i<= loopNumber; i++){
			
			if (isQuarterSignEnabled && ( i % 3 == 0 )) {
			 	timeEncodingHolder.append(Lights.RED.getLightSymbol());
			} else {
				timeEncodingHolder.append(light.getLightSymbol());
			}
			
		}
		
		for(int i = 1; i <= (numberOfLamps - loopNumber); i++){
			timeEncodingHolder.append(Lights.NOLIGHT.getLightSymbol());
		}
	}
}
