--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2023-02-27 00:08:35

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
-- TOC entry 210 (class 1259 OID 44343)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 44344)
-- Name: ordenes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordenes (
    id integer NOT NULL,
    fecha_creacion date DEFAULT CURRENT_DATE,
    total numeric(19,2),
    usuario_id integer
);


ALTER TABLE public.ordenes OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 44350)
-- Name: ordenproductos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordenproductos (
    id integer NOT NULL,
    cantidad integer NOT NULL,
    fecha_creacion date DEFAULT CURRENT_DATE,
    orden_id integer,
    producto_id integer NOT NULL
);


ALTER TABLE public.ordenproductos OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 44356)
-- Name: precios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.precios (
    id integer NOT NULL,
    precio numeric(19,2)
);


ALTER TABLE public.precios OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 44361)
-- Name: productos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productos (
    id integer NOT NULL,
    nombre character varying(255),
    precio numeric(19,2),
    stock integer
);


ALTER TABLE public.productos OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 44366)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id integer NOT NULL,
    nombre character varying(255)
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 43919)
-- Name: usuarios_ordenes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios_ordenes (
    usuario_id integer NOT NULL,
    ordenes_id integer NOT NULL
);


ALTER TABLE public.usuarios_ordenes OWNER TO postgres;

--
-- TOC entry 3189 (class 2606 OID 44349)
-- Name: ordenes ordenes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes
    ADD CONSTRAINT ordenes_pkey PRIMARY KEY (id);


--
-- TOC entry 3191 (class 2606 OID 44355)
-- Name: ordenproductos ordenproductos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenproductos
    ADD CONSTRAINT ordenproductos_pkey PRIMARY KEY (id);


--
-- TOC entry 3193 (class 2606 OID 44360)
-- Name: precios precios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precios
    ADD CONSTRAINT precios_pkey PRIMARY KEY (id);


--
-- TOC entry 3195 (class 2606 OID 44365)
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- TOC entry 3187 (class 2606 OID 43923)
-- Name: usuarios_ordenes uk_fwp8voavethhmju1et38fwhq1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios_ordenes
    ADD CONSTRAINT uk_fwp8voavethhmju1et38fwhq1 UNIQUE (ordenes_id);


--
-- TOC entry 3197 (class 2606 OID 44370)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 3199 (class 2606 OID 44376)
-- Name: ordenproductos fkqd4q055nmf99mc8eww7bndfy1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenproductos
    ADD CONSTRAINT fkqd4q055nmf99mc8eww7bndfy1 FOREIGN KEY (orden_id) REFERENCES public.ordenes(id);


--
-- TOC entry 3198 (class 2606 OID 44371)
-- Name: ordenes fksqu43gsd6mtx7b1siww96324; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordenes
    ADD CONSTRAINT fksqu43gsd6mtx7b1siww96324 FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);


-- Completed on 2023-02-27 00:08:35

--
-- PostgreSQL database dump complete
--

