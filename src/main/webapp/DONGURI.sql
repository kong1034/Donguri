CREATE TABLE d_donation (
    d_no NUMBER PRIMARY KEY,
    u_id VARCHAR2(50) NOT NULL,
    d_title VARCHAR2(100) NOT NULL,
    d_content VARCHAR2(200) NOT NULL,
    d_date DATE NOT NULL
);

CREATE TABLE d_payment (
    p_no NUMBER PRIMARY KEY,
    d_no NUMBER NOT NULL,
    u_id VARCHAR2(50) NOT NULL,
    p_price NUMBER NOT NULL,
    p_date DATE NOT NULL,
    FOREIGN KEY (d_no) REFERENCES donation_list(d_no)
);

