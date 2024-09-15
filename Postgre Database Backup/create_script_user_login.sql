-- Table: public.user_login

-- DROP TABLE IF EXISTS public.user_login;

CREATE TABLE IF NOT EXISTS public.user_login
(
    user_id integer NOT NULL DEFAULT nextval('user_login_user_id_seq'::regclass),
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password_hash character varying(100) COLLATE pg_catalog."default" NOT NULL,
    user_status character varying(1) COLLATE pg_catalog."default" DEFAULT 'N'::character varying,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT user_login_pkey PRIMARY KEY (user_id),
    CONSTRAINT user_login_username_key UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_login
    OWNER to postgres;