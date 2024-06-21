CREATE TABLE d_donation_list (
    d_no NUMBER PRIMARY KEY,
    u_id VARCHAR2(50) NOT NULL,
    d_title VARCHAR2(100) NOT NULL,
    d_content VARCHAR2(200) NOT NULL,
    d_date DATE NOT NULL,
    FOREIGN KEY (u_id) REFERENCES d_user(u_id)
);

CREATE TABLE d_payment (
    p_no NUMBER PRIMARY KEY,
    d_no NUMBER NOT NULL,
    u_id VARCHAR2(50) NOT NULL,
    p_price NUMBER NOT NULL,
    p_date DATE NOT NULL,
    FOREIGN KEY (d_no) REFERENCES d_donation_list(d_no),
    FOREIGN KEY (u_id) REFERENCES d_user(u_id)
);

create SEQUENCE d_donation_list_seq;

create SEQUENCE d_payment_seq;

select * from d_donation_list;
select * from d_payment;