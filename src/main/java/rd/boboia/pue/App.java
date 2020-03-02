package rd.boboia.pue;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import rd.boboia.pue.calc.DaysAndPercentageCalculator;

public class App {

	public static void main(String[] args) {
		
		// Change GUI look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// Default values
		LocalDate startDate = LocalDate.of(2020, 3, 1);
		LocalDate endDate = LocalDate.of(2020, 8, 31);
		
		// Check arguments
		if (args.length == 2) {
			
			// Parse arguments
			try {
				startDate = LocalDate.parse(args[0]);
				endDate = LocalDate.parse(args[1]);
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "Invalid date format. The expected format is: YYYY-MM-DD.", "Invalid format", JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
			
		}
		
		// Get current date
		LocalDate currentDate = LocalDate.now(Clock.systemDefaultZone());

		// Check that end date is not before the current date
		if (endDate.isBefore(currentDate)) {
			JOptionPane.showMessageDialog(null, "End date can not be before the current date (" + currentDate + ").", "End date error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}

		// Check that start date is not after the current date
		if (startDate.isAfter(currentDate)) {
			JOptionPane.showMessageDialog(null, "Start date can not be after the current date (" + currentDate + ").", "Start date error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		
		// Get probability
		float probability = DaysAndPercentageCalculator.getCurrentPercentage(startDate, endDate);
		
		// Show probability
		JOptionPane.showMessageDialog(null, "Current percentage: " + probability + "%", "Progress percentage", JOptionPane.INFORMATION_MESSAGE);
	}

}
