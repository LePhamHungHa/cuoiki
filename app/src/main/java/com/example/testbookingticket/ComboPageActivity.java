package com.example.testbookingticket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ComboPageActivity extends AppCompatActivity {


    private LinearLayout backpage, listCB, show_cb, cb1, cb2, cb3;
    private Button btn_up_cb1, btn_down_cb1, btn_down_cb3, btn_down_cb2, btn_up_cb3, btn_up_cb2;
    public TextView total, soluongcb1, soluongcb2, soluongcb3;
    private ImageView arrowImageView, nextPage;
    public int value_cb1, value_cb2, value_cb3 = 0;
    private int gia_cb1, gia_cb2, gia_cb3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_combo_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.combopage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backpage= findViewById(R.id.btn_backpage);
        listCB = findViewById(R.id.listCB);
        show_cb= findViewById(R.id.btn_show_cb);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);

        btn_up_cb1 = cb1.findViewById(R.id.btn_up_1);
        btn_up_cb2 = cb2.findViewById(R.id.btn_up_2);
        btn_up_cb3 = cb3.findViewById(R.id.btn_up_3);

        btn_down_cb1 = cb1.findViewById(R.id.btn_down_1);
        btn_down_cb2 = cb2.findViewById(R.id.btn_down_2);
        btn_down_cb3 = cb3.findViewById(R.id.btn_down_3);

        nextPage = findViewById(R.id.nextPage);

        arrowImageView  = findViewById(R.id.arrow_image_view);

        soluongcb1 = findViewById(R.id.soluongcb1);
        soluongcb2 = findViewById(R.id.soluongcb2);
        soluongcb3 = findViewById(R.id.soluongcb3);
        total = findViewById(R.id.total);

        // Tìm và tham chiếu đến các TextView có id tương ứng
        TextView priceTextView1 = findViewById(R.id.price_cb1);
        TextView priceTextView2 = findViewById(R.id.price_cb2);
        TextView priceTextView3 = findViewById(R.id.price_cb3);

        // Lấy chuỗi văn bản từ mỗi TextView
        String priceString1 = priceTextView1.getText().toString();
        String priceString2 = priceTextView2.getText().toString();
        String priceString3 = priceTextView3.getText().toString();

        // Loại bỏ các ký tự không phải là số khỏi mỗi chuỗi
        String numberOnly1 = priceString1.replaceAll("[^0-9]", "");
        String numberOnly2 = priceString2.replaceAll("[^0-9]", "");
        String numberOnly3 = priceString3.replaceAll("[^0-9]", "");

        // Chuyển đổi mỗi chuỗi thành số nguyên
        gia_cb1 = Integer.parseInt(numberOnly1);
        gia_cb2 = Integer.parseInt(numberOnly2);
        gia_cb3 = Integer.parseInt(numberOnly3);


//        Trở lại trang trước
        backpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComboPageActivity.this, SeatActivity.class);
                startActivity(intent);
            }
        });

//        show danh sách combo
        show_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCB.getVisibility() == View.GONE){
                    listCB.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Xin mời bạn chọn combo", Toast.LENGTH_SHORT).show();
                }else{
                    listCB.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Bạn vừa tắt combo", Toast.LENGTH_SHORT).show();

                }

                if (arrowImageView .getTag() == null || arrowImageView.getTag().equals("right")) {
                    arrowImageView.setImageResource(R.drawable.arrow_drop_down_paypage);
                    arrowImageView.setTag("down");
                } else {
                    arrowImageView.setImageResource(R.drawable.arrow_right_paypage);
                    arrowImageView.setTag("right");
                }
            }
        });

//        Tăng giá trị combo
        btn_up_cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value_cb1 < 10) {
                    value_cb1++;
                    soluongcb1.setText(String.valueOf(value_cb1));
                }
                updateTotal();
            }
        });

        btn_up_cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value_cb2 < 10) {
                    value_cb2++;
                    soluongcb2.setText(String.valueOf(value_cb2));
                }
                updateTotal();
            }
        });

        btn_up_cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value_cb3 < 10) {
                    value_cb3++;
                    soluongcb3.setText(String.valueOf(value_cb3));
                }
                updateTotal();
            }
        });

//        Giảm giá trị combo
        btn_down_cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value_cb1 >0){
                    value_cb1--;
                    soluongcb1.setText(String.valueOf(value_cb1));
                }
                updateTotal();
            }
        });
        btn_down_cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value_cb2 >0){
                    value_cb2--;
                    soluongcb2.setText(String.valueOf(value_cb2));
                }
                updateTotal();
            }
        });
        btn_down_cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value_cb3 >0){
                    value_cb3--;
                    soluongcb3.setText(String.valueOf(value_cb3));
                }
                updateTotal();
            }
        });

//        Sang trang tiếp theo
       nextPage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(ComboPageActivity.this, PayPageMainActivity.class);
               startActivity(intent);
           }
       });
    }

    public void updateTotal(){
        int tongcong = 95000 + (value_cb1 * gia_cb1) + (value_cb2 * gia_cb2) + (value_cb3 * gia_cb3);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String formattedTongcong = decimalFormat.format(tongcong);
        total.setText("Tổng cộng: " + formattedTongcong + " đ");
    }
}