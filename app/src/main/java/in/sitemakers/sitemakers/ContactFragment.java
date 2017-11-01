package in.sitemakers.sitemakers;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Amit Gupta on 10/24/2017.
 */

public class ContactFragment extends Fragment {
    Button Send_feedback;
    EditText nameField,subjectField,emailField,messageField;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact,container,false);

        nameField = (EditText) v.findViewById(R.id.txtName);
        subjectField = (EditText) v.findViewById(R.id.txtSubject);
        /*emailField = (EditText) v.findViewById(R.id.txtEmail);*/
        messageField = (EditText) v.findViewById(R.id.txtMessage);
        Send_feedback = (Button) v.findViewById(R.id.buttonSend);

        Send_feedback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String[] TO = {"info@sitemakers.in"};
                String b_name = nameField.getText().toString();
                String b_subject = subjectField.getText().toString();
                /*String b_email = emailField.getText().toString();*/
                String b_message = messageField.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);

                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_TEXT,b_name);
                email.putExtra(Intent.EXTRA_EMAIL, TO);
                /*email.putExtra(Intent.EXTRA_EMAIL, new String[]{ b_email});*/
                email.putExtra(Intent.EXTRA_SUBJECT, b_subject);
                email.putExtra(Intent.EXTRA_TEXT, b_message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
        getActivity().setTitle("Contact us");
        return v;
    }

}
