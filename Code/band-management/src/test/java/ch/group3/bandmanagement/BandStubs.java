package ch.group3.bandmanagement;

import ch.group3.bandmanagement.model.Band;

import java.time.LocalDate;

public class BandStubs {
	public static Band validBandWithOutDissolutionDate() {
		Band band = new Band();
		band.setBandName("Valid Band");
		band.setGenre("Rock");
		band.setFoundingDate(LocalDate.of(2000, 1, 1));
		band.setBandMembers(5);
		return band;
	}

	public static Band validBandWithDissolutionDate(LocalDate dissolutionDate) {
		Band band = new Band();
		band.setBandName("Valid Band With Dissolution");
		band.setGenre("Rock");
		band.setFoundingDate(LocalDate.of(2000, 1, 1));
		band.setBandMembers(5);
		band.setDissolutionDate(dissolutionDate);
		return band;
	}

	public static Band bandWithDates(LocalDate foundingDate, LocalDate dissolutionDate) {
		Band band = new Band();
		band.setBandName("Band With Date");
		band.setGenre("Rock");
		band.setFoundingDate(foundingDate);
		band.setBandMembers(5);
		band.setDissolutionDate(dissolutionDate);
		return band;
	}


}
