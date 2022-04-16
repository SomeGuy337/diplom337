-- Table: public.employees

-- DROP TABLE IF EXISTS public.employees;

CREATE TABLE IF NOT EXISTS public.employees
(
    id integer NOT NULL DEFAULT nextval('employees_id_seq'::regclass),
    name character varying(15) COLLATE pg_catalog."default",
    surname character varying(25) COLLATE pg_catalog."default",
    department character varying(20) COLLATE pg_catalog."default",
    salary integer,
    CONSTRAINT employees_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employees
    OWNER to postgres;