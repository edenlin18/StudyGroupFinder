package com.ucsd.studygroupfinder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import com.ucsd.studygroupfinder.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditGroupActivity extends Activity {

	private TimePickerDialog timePickDialog = null;
	private Spinner spinner;
	private EditText startDate, startTime, description, address, subject;
	private Spinner school;
	private int groupId;
	private String initialDate;
	private String initialMonth;
	private String initialYear;
	private Button confirmButton;
	private DatePickerDialog dialog = null;
	Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_group);
	/*
		if( isCreator )
		{
			// read from xml or return values from alvin's function
			startTime = (EditText) findViewById(R.id.StartTimeInput);
			startTime.setText();
			startDate = (EditText) findViewById(R.id.StartDateInput);
			startDate.setText();
			description = (EditText) findViewById(R.id.DescriptionInput);
			description.setText();
			address = (EditText) findViewById(R.id.AddressInput);
			address.setText();
			subject = (EditText) findViewById(R.id.SubjectInput);
			subject.setText();
			int index = 0;
			String schoolCheck = ...;
			String arr[] = getResources().getStringArray(R.array.school_arrays);
			while( index < arr.length() )
			{
				if( schoolCheck == arr[ index ] )
					break;
				index++;
			}
			spinner.setSelection( index );
		}
		else
		{
			
			confirmButton = (Button) findViewById(R.id.ConfirmButton);
			confirmButton.setEnabled(false);
			
			startTime = (EditText) findViewById(R.id.StartTimeInput);
			startDate = (EditText) findViewById(R.id.StartDateInput);
		}
*/
	}

	public void StartDate(View v) {
		context = getApplicationContext();
		startDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Calendar dtTxt = null;
				String preExistingDate = (String) startDate.getText().toString();
				Log.d("Check date", preExistingDate);

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
					dtTxt.setTimeInMillis(System.currentTimeMillis());
					if (dialog == null) {
						dialog = new DatePickerDialog(v.getContext(),
								new PickDate(), dtTxt.get(Calendar.YEAR), dtTxt
										.get(Calendar.MONTH), dtTxt
										.get(Calendar.DAY_OF_MONTH));
					}
					dialog.updateDate(dtTxt.get(Calendar.YEAR),
							dtTxt.get(Calendar.MONTH),
							dtTxt.get(Calendar.DAY_OF_MONTH));
				}

				dialog.show();
			}

		});

	}

	private class PickDate implements DatePickerDialog.OnDateSetListener {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			view.updateDate(year, monthOfYear, dayOfMonth);
			startDate.setText(monthOfYear + 1 + "/" + dayOfMonth + "/" + year);
			dialog.hide();
		}

	}

	public void StartTime(View v) {
		context = getApplicationContext();
		startTime.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String time = startTime.getText().toString();

				if (time != null && !time.equals("")) {
					StringTokenizer st = new StringTokenizer(time, ":");
					String timeHour = st.nextToken();
					String timeMinute = st.nextToken();

					try {
						timePickDialog = new TimePickerDialog(v.getContext(),
								new TimePickHandler(), Integer
										.parseInt(timeHour), Integer
										.parseInt(timeMinute), false);
					} catch (NumberFormatException e) {
					}

				} else {
					timePickDialog = new TimePickerDialog(v.getContext(),
							new TimePickHandler(), 10, 45, false);
				}

				timePickDialog.show();
			}
		});
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

			startTime.setText(strHrsToShow + ":" + minute + "  " + am_pm);
			timePickDialog.hide();

		}

	}
	
	
	public void confirm( View v )
	{
		
		finish();
	}


	
	
	
	
	
	
	
	
	public void addItemsOnSpinner() {

		spinner = (Spinner) findViewById(R.id.SchoolInput);
		List<String> list = new ArrayList<String>();
		list.add("list 1");
		list.add("list 2");
		list.add("list 3");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
	}

	public void addListenerOnSpinnerItemSelection() {
		spinner = (Spinner) findViewById(R.id.SchoolInput);
		spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

	public class CustomOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			Toast.makeText(
					parent.getContext(),
					"OnItemSelectedListener : "
							+ parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}

	}

}
