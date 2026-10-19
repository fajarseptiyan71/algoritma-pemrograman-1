import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Main {
	public static void main() {
		NumberFormat idrFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

		ArrayList<Salary> salaries = new ArrayList<>();
		salaries.add(new Salary("A", 5000000));
		salaries.add(new Salary("B", 6500000));
		salaries.add(new Salary("C", 9500000));

		ArrayList<Overtime> overtimes = new ArrayList<>();
		overtimes.add(new Overtime(1, 0.30f));
		overtimes.add(new Overtime(2, 0.32f));
		overtimes.add(new Overtime(3, 0.34f));
		overtimes.add(new Overtime(4, 0.36f));
		overtimes.add(new Overtime(5, 0.38f));
		

		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Masukkan Golongan: ");
			String inputType = scan.nextLine().trim().toUpperCase();

			Salary selectedSalary = null;
			for (Salary salary : salaries) {
				if (salary.GetType().equals(inputType)) {
					selectedSalary = salary;
					break;
				}
			}

			if (selectedSalary == null) {
				System.out.println("Golongan tidak ditemukan!");
				return;
			}
			

			System.out.print("Apakah Lembur [y/n]: ");
			boolean isOvertime = scan.nextLine().trim().equalsIgnoreCase("y");

			if (!isOvertime) {
				System.out.println("Golongan: " + selectedSalary.GetType());
				System.out.println("Gaji: " + idrFormat.format(selectedSalary.GetAmount()));
				return;
			}

			System.out.print("Masukkan Durasi: ");
			if (!scan.hasNextInt()) {
				System.out.println("Durasi harus berupa angka!");
				return;
			}


			int inputDuration = scan.nextInt();
			if (inputDuration > 5) {
				inputDuration = 5;
			}

			if (inputDuration < 1) {
				System.out.println("Durasi tidak valid");
				return;
			}

			Overtime selectedOvertime = null;
			for (Overtime overtime : overtimes) {
				if (overtime.GetDuration() == inputDuration) {
					selectedOvertime = overtime;
					break;
				}
			}

			if (selectedOvertime == null) {
				System.out.println("Durasi lembur tidak ditemukan!");
				return;
			}


			Integer overtimeSalary = selectedOvertime.GetSalary(selectedSalary);
			Integer salary = selectedSalary.GetSalary(overtimeSalary);

			System.out.println("Golongan: " + selectedSalary.GetType());
			System.out.println("Lembur: " + selectedOvertime.GetDuration() + " jam");
			System.out.println("Gaji: " + idrFormat.format(selectedSalary.GetAmount()));
			System.out.println("Upah Lembur: " + idrFormat.format(overtimeSalary));
			System.out.println("total: " + idrFormat.format(salary));
			
		}
	}
}
