package com.vedicpoojaujjain;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.vedicpoojaujjain.R;

public class BottomSheet extends BottomSheetDialogFragment {
LinearLayout whastapp,phone,email,link;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottomsheet,
                container, false);

        whastapp=v.findViewById(R.id.whatsapp);
        phone=v.findViewById(R.id.phone);
        email=v.findViewById(R.id.email);
        link=v.findViewById(R.id.link);

        whastapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Contact With Rajveer Singh On Whatsapp ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                getActivity().finish();
                                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/917580999942"));
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Send Message On Whatsapp");
                alert.show();
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Contact With Rajveer Singh On Call ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                getActivity().finish();

                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "7580999942", null)));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();


                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Call");
                alert.show();

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Send Mail to Rajveer Singh ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                getActivity().finish();
                                Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:rvsinghrs6@gmail.com"));
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Email");
                alert.show();

            }
        });
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Contact With Rajveer Singh On Linkedln ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                getActivity().finish();
                                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rajveer-singh-3b7639188"));
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Linkedln");
                alert.show();

            }
        });

        return v;
    }
}
