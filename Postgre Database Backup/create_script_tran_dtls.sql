-- Table: public.tran_dtls

-- DROP TABLE IF EXISTS public.tran_dtls;

CREATE TABLE IF NOT EXISTS public.tran_dtls
(
    cust_id integer NOT NULL,
    modeoftransaction character varying(100) COLLATE pg_catalog."default",
    amtoftransaction numeric(15,2),
    transactiontype character varying(50) COLLATE pg_catalog."default",
    dot date,
    transactionno character varying(100) COLLATE pg_catalog."default" NOT NULL,
    balance numeric(15,2),
    accountno character varying(20) COLLATE pg_catalog."default" NOT NULL,
    updateno integer DEFAULT nextval('tran_dtls_updateno_seq'::regclass),
    CONSTRAINT tran_dtls_pkey PRIMARY KEY (transactionno)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tran_dtls
    OWNER to postgres;