--
-- PostgreSQL database cluster dump
--

-- Started on 2024-02-27 14:27:57

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE base_app_user;
ALTER ROLE base_app_user WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION NOBYPASSRLS CONNECTION LIMIT 115 PASSWORD 'SCRAM-SHA-256$4096:eMSGWbzWy/gA0FSqPsp4LA==$5rShbpiJMCegYZeoajRMSr2uqWGtjuJJdyx7tZaZoZA=:xQaOVuOI4B4BtZqp/yvjc0EVKt4MF1HHcx0hKDojpMQ=';
CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:aWlYoGZ3yHMPsns4oAmFBA==$KMHXOlP0TpkroRbFhiKQI0AHeqrQeFHupNj7PpnD4vw=:bGfyNMYtrM/k9Sd9f2mQTiOXWsUBXLtdF2oISUyOgpA=';


--
-- Role memberships
--

GRANT pg_read_all_data TO base_app_user WITH ADMIN OPTION GRANTED BY postgres;
GRANT pg_write_all_data TO base_app_user WITH ADMIN OPTION GRANTED BY postgres;




--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.9
-- Dumped by pg_dump version 14.9

-- Started on 2024-02-27 14:27:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2024-02-27 14:28:02

--
-- PostgreSQL database dump complete
--

--
-- Database "base_db" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.9
-- Dumped by pg_dump version 14.9

-- Started on 2024-02-27 14:28:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3353 (class 1262 OID 16395)
-- Name: base_db; Type: DATABASE; Schema: -; Owner: base_app_user
--

CREATE DATABASE base_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Malaysia.1252';


ALTER DATABASE base_db OWNER TO base_app_user;

\connect base_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3355 (class 0 OID 0)
-- Name: base_db; Type: DATABASE PROPERTIES; Schema: -; Owner: base_app_user
--

ALTER DATABASE base_db CONNECTION LIMIT = 600;


\connect base_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 16396)
-- Name: base_project_app; Type: SCHEMA; Schema: -; Owner: base_app_user
--

CREATE SCHEMA base_project_app;


ALTER SCHEMA base_project_app OWNER TO base_app_user;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 16439)
-- Name: hibernate_sequences; Type: TABLE; Schema: base_project_app; Owner: base_app_user
--

CREATE TABLE base_project_app.hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    next_val bigint
);


ALTER TABLE base_project_app.hibernate_sequences OWNER TO base_app_user;

--
-- TOC entry 209 (class 1259 OID 16397)
-- Name: spring_session; Type: TABLE; Schema: base_project_app; Owner: base_app_user
--

CREATE TABLE base_project_app.spring_session (
    primary_id character(36) NOT NULL,
    session_id character(36) NOT NULL,
    creation_time bigint NOT NULL,
    last_access_time bigint NOT NULL,
    max_inactive_interval integer NOT NULL,
    expiry_time bigint NOT NULL,
    principal_name character varying(100)
);


ALTER TABLE base_project_app.spring_session OWNER TO base_app_user;

--
-- TOC entry 210 (class 1259 OID 16405)
-- Name: spring_session_attributes; Type: TABLE; Schema: base_project_app; Owner: base_app_user
--

CREATE TABLE base_project_app.spring_session_attributes (
    session_primary_id character(36) NOT NULL,
    attribute_name character varying(200) NOT NULL,
    attribute_bytes bytea NOT NULL
);


ALTER TABLE base_project_app.spring_session_attributes OWNER TO base_app_user;

--
-- TOC entry 211 (class 1259 OID 16419)
-- Name: sys99_encrypt_type; Type: TABLE; Schema: base_project_app; Owner: base_app_user
--

CREATE TABLE base_project_app.sys99_encrypt_type (
    encrypt_cd character varying NOT NULL,
    encrypt_desc character varying,
    encrypt_type character varying,
    encrypt_lib_url character varying
);


ALTER TABLE base_project_app.sys99_encrypt_type OWNER TO base_app_user;

--
-- TOC entry 214 (class 1259 OID 24805)
-- Name: user01; Type: TABLE; Schema: base_project_app; Owner: postgres
--

CREATE TABLE base_project_app.user01 (
    user_id bigint NOT NULL,
    user_name character varying(50) NOT NULL,
    user_password character varying(150) NOT NULL,
    user_salt_key character varying(100),
    user_encrypt_cd character varying(15),
    user_role_cd character varying(10),
    user_email character varying(50)
);


ALTER TABLE base_project_app.user01 OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24820)
-- Name: user01_user_id_seq; Type: SEQUENCE; Schema: base_project_app; Owner: postgres
--

ALTER TABLE base_project_app.user01 ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME base_project_app.user01_user_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 999999999999
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 24586)
-- Name: user99_roles; Type: TABLE; Schema: base_project_app; Owner: base_app_user
--

CREATE TABLE base_project_app.user99_roles (
    role_cd character varying(10) NOT NULL,
    role_desc character varying(100)
);


ALTER TABLE base_project_app.user99_roles OWNER TO base_app_user;

--
-- TOC entry 3344 (class 0 OID 16439)
-- Dependencies: 212
-- Data for Name: hibernate_sequences; Type: TABLE DATA; Schema: base_project_app; Owner: base_app_user
--

COPY base_project_app.hibernate_sequences (sequence_name, next_val) FROM stdin;
default	50
\.


--
-- TOC entry 3341 (class 0 OID 16397)
-- Dependencies: 209
-- Data for Name: spring_session; Type: TABLE DATA; Schema: base_project_app; Owner: base_app_user
--

COPY base_project_app.spring_session (primary_id, session_id, creation_time, last_access_time, max_inactive_interval, expiry_time, principal_name) FROM stdin;
\.


--
-- TOC entry 3342 (class 0 OID 16405)
-- Dependencies: 210
-- Data for Name: spring_session_attributes; Type: TABLE DATA; Schema: base_project_app; Owner: base_app_user
--

COPY base_project_app.spring_session_attributes (session_primary_id, attribute_name, attribute_bytes) FROM stdin;
\.


--
-- TOC entry 3343 (class 0 OID 16419)
-- Dependencies: 211
-- Data for Name: sys99_encrypt_type; Type: TABLE DATA; Schema: base_project_app; Owner: base_app_user
--

COPY base_project_app.sys99_encrypt_type (encrypt_cd, encrypt_desc, encrypt_type, encrypt_lib_url) FROM stdin;
\.


--
-- TOC entry 3346 (class 0 OID 24805)
-- Dependencies: 214
-- Data for Name: user01; Type: TABLE DATA; Schema: base_project_app; Owner: postgres
--

COPY base_project_app.user01 (user_id, user_name, user_password, user_salt_key, user_encrypt_cd, user_role_cd, user_email) FROM stdin;
1	alyas20	IOIjVEd6vXM6iW8Lz5ZkbQ==	l52w8jkoWWCyVcqZGT90fQ==	\N	\N	alyasamsyar@yahoo.com
\.


--
-- TOC entry 3345 (class 0 OID 24586)
-- Dependencies: 213
-- Data for Name: user99_roles; Type: TABLE DATA; Schema: base_project_app; Owner: base_app_user
--

COPY base_project_app.user99_roles (role_cd, role_desc) FROM stdin;
ADMIN99	admin full access
\.


--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 215
-- Name: user01_user_id_seq; Type: SEQUENCE SET; Schema: base_project_app; Owner: postgres
--

SELECT pg_catalog.setval('base_project_app.user01_user_id_seq', 1, true);


--
-- TOC entry 3194 (class 2606 OID 16443)
-- Name: hibernate_sequences hibernate_sequences_pkey; Type: CONSTRAINT; Schema: base_project_app; Owner: base_app_user
--

ALTER TABLE ONLY base_project_app.hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);


--
-- TOC entry 3190 (class 2606 OID 16411)
-- Name: spring_session_attributes spring_session_attributes_pk; Type: CONSTRAINT; Schema: base_project_app; Owner: base_app_user
--

ALTER TABLE ONLY base_project_app.spring_session_attributes
    ADD CONSTRAINT spring_session_attributes_pk PRIMARY KEY (session_primary_id, attribute_name);


--
-- TOC entry 3188 (class 2606 OID 16401)
-- Name: spring_session spring_session_pk; Type: CONSTRAINT; Schema: base_project_app; Owner: base_app_user
--

ALTER TABLE ONLY base_project_app.spring_session
    ADD CONSTRAINT spring_session_pk PRIMARY KEY (primary_id);


--
-- TOC entry 3192 (class 2606 OID 24606)
-- Name: sys99_encrypt_type sys99_encrypttype_pk; Type: CONSTRAINT; Schema: base_project_app; Owner: base_app_user
--

ALTER TABLE ONLY base_project_app.sys99_encrypt_type
    ADD CONSTRAINT sys99_encrypttype_pk PRIMARY KEY (encrypt_cd);


--
-- TOC entry 3198 (class 2606 OID 24841)
-- Name: user01 user01_pkey; Type: CONSTRAINT; Schema: base_project_app; Owner: postgres
--

ALTER TABLE ONLY base_project_app.user01
    ADD CONSTRAINT user01_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3196 (class 2606 OID 24678)
-- Name: user99_roles user99_roles_pk; Type: CONSTRAINT; Schema: base_project_app; Owner: base_app_user
--

ALTER TABLE ONLY base_project_app.user99_roles
    ADD CONSTRAINT user99_roles_pk PRIMARY KEY (role_cd);


--
-- TOC entry 3184 (class 1259 OID 16402)
-- Name: spring_session_ix1; Type: INDEX; Schema: base_project_app; Owner: base_app_user
--

CREATE UNIQUE INDEX spring_session_ix1 ON base_project_app.spring_session USING btree (session_id);


--
-- TOC entry 3185 (class 1259 OID 16403)
-- Name: spring_session_ix2; Type: INDEX; Schema: base_project_app; Owner: base_app_user
--

CREATE INDEX spring_session_ix2 ON base_project_app.spring_session USING btree (expiry_time);


--
-- TOC entry 3186 (class 1259 OID 16404)
-- Name: spring_session_ix3; Type: INDEX; Schema: base_project_app; Owner: base_app_user
--

CREATE INDEX spring_session_ix3 ON base_project_app.spring_session USING btree (principal_name);


--
-- TOC entry 3199 (class 2606 OID 16412)
-- Name: spring_session_attributes spring_session_attributes_fk; Type: FK CONSTRAINT; Schema: base_project_app; Owner: base_app_user
--

ALTER TABLE ONLY base_project_app.spring_session_attributes
    ADD CONSTRAINT spring_session_attributes_fk FOREIGN KEY (session_primary_id) REFERENCES base_project_app.spring_session(primary_id) ON DELETE CASCADE;


--
-- TOC entry 3200 (class 2606 OID 24810)
-- Name: user01 user01_fk; Type: FK CONSTRAINT; Schema: base_project_app; Owner: postgres
--

ALTER TABLE ONLY base_project_app.user01
    ADD CONSTRAINT user01_fk FOREIGN KEY (user_role_cd) REFERENCES base_project_app.user99_roles(role_cd);


--
-- TOC entry 3201 (class 2606 OID 24815)
-- Name: user01 user01_fk_1; Type: FK CONSTRAINT; Schema: base_project_app; Owner: postgres
--

ALTER TABLE ONLY base_project_app.user01
    ADD CONSTRAINT user01_fk_1 FOREIGN KEY (user_encrypt_cd) REFERENCES base_project_app.sys99_encrypt_type(encrypt_cd);


--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 3353
-- Name: DATABASE base_db; Type: ACL; Schema: -; Owner: base_app_user
--

REVOKE ALL ON DATABASE base_db FROM base_app_user;
GRANT CREATE,CONNECT ON DATABASE base_db TO base_app_user;
GRANT TEMPORARY ON DATABASE base_db TO base_app_user WITH GRANT OPTION;


-- Completed on 2024-02-27 14:28:08

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.9
-- Dumped by pg_dump version 14.9

-- Started on 2024-02-27 14:28:08

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3303 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


-- Completed on 2024-02-27 14:28:13

--
-- PostgreSQL database dump complete
--

-- Completed on 2024-02-27 14:28:13

--
-- PostgreSQL database cluster dump complete
--

