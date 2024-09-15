-- Table: public.cust_dtls

-- DROP TABLE IF EXISTS public.cust_dtls;

CREATE TABLE IF NOT EXISTS public.cust_dtls
(
    cust_id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    fname character varying(100) COLLATE pg_catalog."default",
    mname character varying(100) COLLATE pg_catalog."default",
    lname character varying(100) COLLATE pg_catalog."default",
    dob date,
    mobileno character varying(15) COLLATE pg_catalog."default",
    occupation character varying(100) COLLATE pg_catalog."default",
    city character varying(100) COLLATE pg_catalog."default",
    state character varying(100) COLLATE pg_catalog."default",
    addresspin character varying(10) COLLATE pg_catalog."default",
    aadharno character varying(20) COLLATE pg_catalog."default",
    panno character varying(20) COLLATE pg_catalog."default",
    isekycdone character(1) COLLATE pg_catalog."default",
    passportno character varying(20) COLLATE pg_catalog."default",
    accountno character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT cust_dtls_pkey PRIMARY KEY (cust_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cust_dtls
    OWNER to postgres;