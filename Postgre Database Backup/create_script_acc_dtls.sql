-- Table: public.acc_dtls

-- DROP TABLE IF EXISTS public.acc_dtls;

CREATE TABLE IF NOT EXISTS public.acc_dtls
(
    cust_id integer NOT NULL,
    accountno character varying(20) COLLATE pg_catalog."default",
    ifsccd character varying(20) COLLATE pg_catalog."default",
    branch character varying(100) COLLATE pg_catalog."default",
    location character varying(100) COLLATE pg_catalog."default",
    accounttype character varying(50) COLLATE pg_catalog."default",
    status character varying(20) COLLATE pg_catalog."default",
    aod date,
    openingbalance numeric(15,2),
    loanaccountno character varying(20) COLLATE pg_catalog."default",
    loanamt numeric(15,2),
    roi numeric(5,2),
    tenure integer,
    CONSTRAINT acc_dtls_pkey PRIMARY KEY (cust_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.acc_dtls
    OWNER to postgres;