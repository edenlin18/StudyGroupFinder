package com.ucsd.studygroupfinder;

import java.util.Calendar;
import java.util.StringTokenizer;
import com.ucsd.studygroupfinder.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class EditGroupActivity extends Activity {
	private EditText edTxt = null;
	private TimePickerDialog timePickDialog = null;

	private EditText txtView, txtView2;
	private String initialDate;
	private String initialMonth;
	private String initialYear;
	private DatePickerDialog dialog = null;
	Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_group);
		txtView = (EditText) findViewById(R.id.EDITeditText4);
		txtView2 = (EditText) findViewById(R.id.EDITeditText5);

		context = getApplicationContext();

		txtView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Calendar dtTxt = null;
				String preExistingDate = (String) txtView.getText().toString();

				if (preExistingDate != null && !preExistingDate.equals("")) {
					StringTokenizer st = new StringTokenizer(preExistingDate,
							"/");
					initialMonth = st.nextToken();
					initialDate = st.nextToken();
					initialYear = st.nextToken();
					if (dialog == null)
						dialog = new DatePickerDialog(v.getContext(),
								new PickDate(), Integer.parseInt(initialYear),
								Integer.parseInt(initialMonth) - 1, Integer
										.parseInt(initialDate));
					dialog.updateDate(Integer.parseInt(initialYear),
							Integer.parseInt(initialMonth) - 1,
							Integer.parseInt(initialDate));

				} else {
					dtTxt = Calendar.getInstance();
					if (dialog == null)
						dialog = new DatePickerDialog(v.getContext(),
								new PickDate(), dtTxt.getTime().getYear(),
								dtTxt.getTime().getMonth(), dtTxt.getTime()
										.getDay());
					dialog.updateDate(dtTxt.getTime().getYear(), dtTxt
							.getTime().getMonth(), dtTxt.getTime().getDay());
				}

				dialog.show();
			}

		});

		txtView2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String time = txtView2.getText().toString();

				if (time != null && !time.equals("")) {
					StringTokenizer st = new StringTokenizer(time, ":");
					String timeHour = st.nextToken();
					String timeMinute = st.nextToken();

					try
					{
						timePickDialog = new TimePickerDialog(v.getContext(),
								new TimePickHandler(), Integer.parseInt(timeHour), 
								Integer.parseInt(timeMinute), true);			
					} catch(NumberFormatException e){}

				} else {
					timePickDialog = new TimePickerDialog(v.getContext(),
							new TimePickHandler(), 10, 45, true);
				}

				timePickDialog.show();
			}
		});

	}

	private class PickDate implements DatePickerDialog.OnDateSetListener {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			view.updateDate(year, monthOfYear, dayOfMonth);
			txtView.setText(monthOfYear + "/" + dayOfMonth + "/" + year);
			dialog.hide();
		}

	}

	private class TimePickHandler implements OnTimeSetListener {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

			String am_pm = "";

			Calendar datetime = Calendar.getInstance();
			datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
			datetime.set(Calendar.MINUTE, minute);

			if (datetime.get(Calendar.AM_PM) == Calendar.AM)
				am_pm = "AM";
			else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
				am_pm = "PM";

			String strHrsToShow = (datetime.get(Calendar.HOUR) == 0) ? "12"
					: datetime.get(Calendar.HOUR) + "";

			txtView2.setText(strHrsToShow + ":" + minute + am_pm);
			timePickDialog.hide();

		}

	}

}
