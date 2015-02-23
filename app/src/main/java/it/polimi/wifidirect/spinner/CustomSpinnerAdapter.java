package it.polimi.wifidirect.spinner;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import it.polimi.wifidirect.R;

/**
 * Created by Stefano Cappa on 31/01/15.
 *
 * The custom spinner adapter
 */
public class CustomSpinnerAdapter extends ArrayAdapter<SpinnerRow> {

	private Activity context;
	private ArrayList<SpinnerRow> spinnerRow;

    /**
     * Constructor with required parameters
     * @param context The context
     * @param resource The resource
     * @param spinnerRow The list of elements
     */
	public CustomSpinnerAdapter(Activity context, int resource, ArrayList<SpinnerRow> spinnerRow) {
		super(context, resource, spinnerRow);
		this.context = context;
		this.spinnerRow = spinnerRow;

	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
}


	@Override
	public View getDropDownView(int position, View convertView,
			ViewGroup parent) {

		View row = convertView;

		if (row == null) {

			LayoutInflater inflater = context.getLayoutInflater();
			row = inflater.inflate(R.layout.spinner_row, parent, false);

		}

		SpinnerRow current = spinnerRow.get(position);

		TextView name = (TextView) row.findViewById(R.id.spinner_row_label);
		name.setText(current.getName());


		return row;
	}

}