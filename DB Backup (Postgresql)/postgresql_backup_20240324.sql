PGDMP         *                |            base_db    14.9    14.9 &               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                        0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            !           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            "           1262    16395    base_db    DATABASE     f   CREATE DATABASE base_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Malaysia.1252';
    DROP DATABASE base_db;
                base_app_user    false            #           0    0    DATABASE base_db    ACL     �   REVOKE ALL ON DATABASE base_db FROM base_app_user;
GRANT CREATE,CONNECT ON DATABASE base_db TO base_app_user;
GRANT TEMPORARY ON DATABASE base_db TO base_app_user WITH GRANT OPTION;
                   base_app_user    false    3362            $           0    0    base_db    DATABASE PROPERTIES     /   ALTER DATABASE base_db CONNECTION LIMIT = 600;
                     base_app_user    false                        2615    16396    base_project_app    SCHEMA         CREATE SCHEMA base_project_app;
    DROP SCHEMA base_project_app;
                base_app_user    false            �            1259    16439    hibernate_sequences    TABLE     ~   CREATE TABLE base_project_app.hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    next_val bigint
);
 1   DROP TABLE base_project_app.hibernate_sequences;
       base_project_app         heap    base_app_user    false    5            �            1259    24847    locale99_type    TABLE     �   CREATE TABLE base_project_app.locale99_type (
    locale_code character varying(4) NOT NULL,
    locale_desc character varying(50)
);
 +   DROP TABLE base_project_app.locale99_type;
       base_project_app         heap    postgres    false    5            �            1259    16397    spring_session    TABLE     @  CREATE TABLE base_project_app.spring_session (
    primary_id character(36) NOT NULL,
    session_id character(36) NOT NULL,
    creation_time bigint NOT NULL,
    last_access_time bigint NOT NULL,
    max_inactive_interval integer NOT NULL,
    expiry_time bigint NOT NULL,
    principal_name character varying(100)
);
 ,   DROP TABLE base_project_app.spring_session;
       base_project_app         heap    base_app_user    false    5            �            1259    16405    spring_session_attributes    TABLE     �   CREATE TABLE base_project_app.spring_session_attributes (
    session_primary_id character(36) NOT NULL,
    attribute_name character varying(200) NOT NULL,
    attribute_bytes bytea NOT NULL
);
 7   DROP TABLE base_project_app.spring_session_attributes;
       base_project_app         heap    base_app_user    false    5            �            1259    16419    sys99_encrypt_type    TABLE     �   CREATE TABLE base_project_app.sys99_encrypt_type (
    encrypt_code character varying NOT NULL,
    encrypt_desc character varying,
    encrypt_type character varying,
    encrypt_lib_url character varying
);
 0   DROP TABLE base_project_app.sys99_encrypt_type;
       base_project_app         heap    base_app_user    false    5            �            1259    24805    user01    TABLE     m  CREATE TABLE base_project_app.user01 (
    user_id bigint NOT NULL,
    user_name character varying(50) NOT NULL,
    user_password character varying(150) NOT NULL,
    user_salt_key character varying(100),
    user_encrypt_cd character varying(15),
    user_role character varying(10),
    user_email character varying(50),
    user_locale character varying(4)
);
 $   DROP TABLE base_project_app.user01;
       base_project_app         heap    postgres    false    5            �            1259    24820    user01_user_id_seq    SEQUENCE     �   ALTER TABLE base_project_app.user01 ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME base_project_app.user01_user_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 999999999999
    CACHE 1
);
            base_project_app          postgres    false    214    5            �            1259    24586    user99_role    TABLE     �   CREATE TABLE base_project_app.user99_role (
    role_code character varying(10) NOT NULL,
    role_desc character varying(100)
);
 )   DROP TABLE base_project_app.user99_role;
       base_project_app         heap    base_app_user    false    5                      0    16439    hibernate_sequences 
   TABLE DATA           P   COPY base_project_app.hibernate_sequences (sequence_name, next_val) FROM stdin;
    base_project_app          base_app_user    false    212   
2                 0    24847    locale99_type 
   TABLE DATA           K   COPY base_project_app.locale99_type (locale_code, locale_desc) FROM stdin;
    base_project_app          postgres    false    216   22                 0    16397    spring_session 
   TABLE DATA           �   COPY base_project_app.spring_session (primary_id, session_id, creation_time, last_access_time, max_inactive_interval, expiry_time, principal_name) FROM stdin;
    base_project_app          base_app_user    false    209   u2                 0    16405    spring_session_attributes 
   TABLE DATA           r   COPY base_project_app.spring_session_attributes (session_primary_id, attribute_name, attribute_bytes) FROM stdin;
    base_project_app          base_app_user    false    210   �2                 0    16419    sys99_encrypt_type 
   TABLE DATA           q   COPY base_project_app.sys99_encrypt_type (encrypt_code, encrypt_desc, encrypt_type, encrypt_lib_url) FROM stdin;
    base_project_app          base_app_user    false    211   �2                 0    24805    user01 
   TABLE DATA           �   COPY base_project_app.user01 (user_id, user_name, user_password, user_salt_key, user_encrypt_cd, user_role, user_email, user_locale) FROM stdin;
    base_project_app          postgres    false    214   �2                 0    24586    user99_role 
   TABLE DATA           E   COPY base_project_app.user99_role (role_code, role_desc) FROM stdin;
    base_project_app          base_app_user    false    213   C3       %           0    0    user01_user_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('base_project_app.user01_user_id_seq', 1, true);
          base_project_app          postgres    false    215            ~           2606    16443 ,   hibernate_sequences hibernate_sequences_pkey 
   CONSTRAINT        ALTER TABLE ONLY base_project_app.hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);
 `   ALTER TABLE ONLY base_project_app.hibernate_sequences DROP CONSTRAINT hibernate_sequences_pkey;
       base_project_app            base_app_user    false    212            �           2606    24851    locale99_type locale99_type_pk 
   CONSTRAINT     o   ALTER TABLE ONLY base_project_app.locale99_type
    ADD CONSTRAINT locale99_type_pk PRIMARY KEY (locale_code);
 R   ALTER TABLE ONLY base_project_app.locale99_type DROP CONSTRAINT locale99_type_pk;
       base_project_app            postgres    false    216            z           2606    16411 6   spring_session_attributes spring_session_attributes_pk 
   CONSTRAINT     �   ALTER TABLE ONLY base_project_app.spring_session_attributes
    ADD CONSTRAINT spring_session_attributes_pk PRIMARY KEY (session_primary_id, attribute_name);
 j   ALTER TABLE ONLY base_project_app.spring_session_attributes DROP CONSTRAINT spring_session_attributes_pk;
       base_project_app            base_app_user    false    210    210            x           2606    16401     spring_session spring_session_pk 
   CONSTRAINT     p   ALTER TABLE ONLY base_project_app.spring_session
    ADD CONSTRAINT spring_session_pk PRIMARY KEY (primary_id);
 T   ALTER TABLE ONLY base_project_app.spring_session DROP CONSTRAINT spring_session_pk;
       base_project_app            base_app_user    false    209            |           2606    24606 '   sys99_encrypt_type sys99_encrypttype_pk 
   CONSTRAINT     y   ALTER TABLE ONLY base_project_app.sys99_encrypt_type
    ADD CONSTRAINT sys99_encrypttype_pk PRIMARY KEY (encrypt_code);
 [   ALTER TABLE ONLY base_project_app.sys99_encrypt_type DROP CONSTRAINT sys99_encrypttype_pk;
       base_project_app            base_app_user    false    211            �           2606    24841    user01 user01_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY base_project_app.user01
    ADD CONSTRAINT user01_pkey PRIMARY KEY (user_id);
 F   ALTER TABLE ONLY base_project_app.user01 DROP CONSTRAINT user01_pkey;
       base_project_app            postgres    false    214            �           2606    24678    user99_role user99_roles_pk 
   CONSTRAINT     j   ALTER TABLE ONLY base_project_app.user99_role
    ADD CONSTRAINT user99_roles_pk PRIMARY KEY (role_code);
 O   ALTER TABLE ONLY base_project_app.user99_role DROP CONSTRAINT user99_roles_pk;
       base_project_app            base_app_user    false    213            �           1259    24857    fki_user01_locale99_type_fk    INDEX     _   CREATE INDEX fki_user01_locale99_type_fk ON base_project_app.user01 USING btree (user_locale);
 9   DROP INDEX base_project_app.fki_user01_locale99_type_fk;
       base_project_app            postgres    false    214            t           1259    16402    spring_session_ix1    INDEX     d   CREATE UNIQUE INDEX spring_session_ix1 ON base_project_app.spring_session USING btree (session_id);
 0   DROP INDEX base_project_app.spring_session_ix1;
       base_project_app            base_app_user    false    209            u           1259    16403    spring_session_ix2    INDEX     ^   CREATE INDEX spring_session_ix2 ON base_project_app.spring_session USING btree (expiry_time);
 0   DROP INDEX base_project_app.spring_session_ix2;
       base_project_app            base_app_user    false    209            v           1259    16404    spring_session_ix3    INDEX     a   CREATE INDEX spring_session_ix3 ON base_project_app.spring_session USING btree (principal_name);
 0   DROP INDEX base_project_app.spring_session_ix3;
       base_project_app            base_app_user    false    209            �           2606    16412 6   spring_session_attributes spring_session_attributes_fk    FK CONSTRAINT     �   ALTER TABLE ONLY base_project_app.spring_session_attributes
    ADD CONSTRAINT spring_session_attributes_fk FOREIGN KEY (session_primary_id) REFERENCES base_project_app.spring_session(primary_id) ON DELETE CASCADE;
 j   ALTER TABLE ONLY base_project_app.spring_session_attributes DROP CONSTRAINT spring_session_attributes_fk;
       base_project_app          base_app_user    false    210    209    3192            �           2606    24852    user01 user01_locale99_type_fk    FK CONSTRAINT     �   ALTER TABLE ONLY base_project_app.user01
    ADD CONSTRAINT user01_locale99_type_fk FOREIGN KEY (user_locale) REFERENCES base_project_app.locale99_type(locale_code);
 R   ALTER TABLE ONLY base_project_app.user01 DROP CONSTRAINT user01_locale99_type_fk;
       base_project_app          postgres    false    3205    214    216            �           2606    24815 #   user01 user01_sys99_encrypt_type_fk    FK CONSTRAINT     �   ALTER TABLE ONLY base_project_app.user01
    ADD CONSTRAINT user01_sys99_encrypt_type_fk FOREIGN KEY (user_encrypt_cd) REFERENCES base_project_app.sys99_encrypt_type(encrypt_code);
 W   ALTER TABLE ONLY base_project_app.user01 DROP CONSTRAINT user01_sys99_encrypt_type_fk;
       base_project_app          postgres    false    214    211    3196            �           2606    24810    user01 user01_user99_role_fk    FK CONSTRAINT     �   ALTER TABLE ONLY base_project_app.user01
    ADD CONSTRAINT user01_user99_role_fk FOREIGN KEY (user_role) REFERENCES base_project_app.user99_role(role_code);
 P   ALTER TABLE ONLY base_project_app.user01 DROP CONSTRAINT user01_user99_role_fk;
       base_project_app          postgres    false    213    3200    214                  x�KIMK,�)�45������ +�         3   x�˭�tJ�H,NT�M�I�,�J��t�K��,��J+�t+J�KN����� =�Y            x������ � �            x������ � �            x������ � �         g   x�3�L̩L,62�����
sM1+��5���2��N
����15*����w�K.�r�4HI��q:��z�YZBI�-�L,r�L����K���̭����� 9�         *   x�st�������,.I�UpL����,.)J,�/����� ��
�     