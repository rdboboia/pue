package rd.boboia.pue.calc;

import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public interface DaysAndPercentageCalculator {

	public static long getDifferenceInDays(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
		return ChronoUnit.DAYS.between(temporal1Inclusive, temporal2Exclusive);
	}

	public static long getCurrentDifference(Temporal temporal1Inclusive) {
		return ChronoUnit.DAYS.between(temporal1Inclusive, LocalDate.now(Clock.systemDefaultZone()));
	}

	public static float getCurrentPercentage(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
		long startEndDifference = ChronoUnit.DAYS.between(temporal1Inclusive, temporal2Exclusive);
		long currentDifference = ChronoUnit.DAYS.between(LocalDate.now(Clock.systemDefaultZone()), temporal2Exclusive);
		
		return ((startEndDifference - currentDifference) / (float)startEndDifference) * 100;
	}

}
