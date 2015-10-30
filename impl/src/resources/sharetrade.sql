---
-- #%L
-- sharegame - Implementation
-- %%
-- Copyright (C) 2003 - 2015 Sakai Project
-- %%
-- Licensed under the Educational Community License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- 
--             http://opensource.org/licenses/ecl2
-- 
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- #L%
---
--
-- PostgreSQL database dump
--

\connect - dhorwitz

SET search_path = public, pg_catalog;

--
-- TOC entry 2 (OID 494510)
-- Name: companies_cid_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE companies_cid_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 3 (OID 494510)
-- Name: companies_cid_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE companies_cid_seq FROM PUBLIC;
GRANT UPDATE ON TABLE companies_cid_seq TO tcarr;


--
-- TOC entry 4 (OID 494512)
-- Name: trades_tid_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE trades_tid_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 5 (OID 494512)
-- Name: trades_tid_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE trades_tid_seq FROM PUBLIC;
GRANT ALL ON TABLE trades_tid_seq TO webserv;
GRANT UPDATE ON TABLE trades_tid_seq TO tcarr;


--
-- TOC entry 6 (OID 494514)
-- Name: closingprices_id_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE closingprices_id_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 7 (OID 494514)
-- Name: closingprices_id_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE closingprices_id_seq FROM PUBLIC;
GRANT UPDATE ON TABLE closingprices_id_seq TO tcarr;


--
-- TOC entry 8 (OID 494516)
-- Name: importlog_importindex_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE importlog_importindex_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 9 (OID 494516)
-- Name: importlog_importindex_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE importlog_importindex_seq FROM PUBLIC;
GRANT UPDATE ON TABLE importlog_importindex_seq TO tcarr;


--
-- TOC entry 10 (OID 494518)
-- Name: indexvalues_id_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE indexvalues_id_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 11 (OID 494518)
-- Name: indexvalues_id_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE indexvalues_id_seq FROM PUBLIC;
GRANT UPDATE ON TABLE indexvalues_id_seq TO tcarr;


--
-- TOC entry 12 (OID 494520)
-- Name: tblgroups_tblgroups_id_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE tblgroups_tblgroups_id_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 13 (OID 494520)
-- Name: tblgroups_tblgroups_id_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE tblgroups_tblgroups_id_seq FROM PUBLIC;
GRANT UPDATE ON TABLE tblgroups_tblgroups_id_seq TO tcarr;


--
-- TOC entry 14 (OID 494522)
-- Name: commodities_fi_commodity_id_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE commodities_fi_commodity_id_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 15 (OID 494522)
-- Name: commodities_fi_commodity_id_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE commodities_fi_commodity_id_seq FROM PUBLIC;
GRANT UPDATE ON TABLE commodities_fi_commodity_id_seq TO tcarr;


\connect - root

SET search_path = public, pg_catalog;

--
-- TOC entry 16 (OID 494524)
-- Name: exchange_rate_rate_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE exchange_rate_rate_id_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 17 (OID 494524)
-- Name: exchange_rate_rate_id_seq; Type: ACL; Schema: public; Owner: root
--

REVOKE ALL ON TABLE exchange_rate_rate_id_seq FROM PUBLIC;
GRANT UPDATE ON TABLE exchange_rate_rate_id_seq TO tcarr;


\connect - dhorwitz

SET search_path = public, pg_catalog;

--
-- TOC entry 31 (OID 494526)
-- Name: bankaccounts; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE bankaccounts (
    mid character varying(10) NOT NULL,
    balance numeric(20,4) DEFAULT 0 NOT NULL
);


--
-- TOC entry 32 (OID 494526)
-- Name: bankaccounts; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE bankaccounts FROM PUBLIC;
GRANT SELECT ON TABLE bankaccounts TO labstudent;
GRANT ALL ON TABLE bankaccounts TO webserv;
GRANT ALL ON TABLE bankaccounts TO tcarr;
GRANT SELECT ON TABLE bankaccounts TO vfrith;


--
-- TOC entry 33 (OID 494529)
-- Name: companies; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE companies (
    cid integer DEFAULT nextval('companies_cid_seq'::text) NOT NULL,
    companyname character varying(50),
    exchangename character varying(50),
    companycode character varying(50),
    website text,
    used boolean,
    quickname character varying(255),
    sector character varying(50),
    active boolean,
    sharesissued integer,
    natureofbusiness text,
    nextresults text
);


--
-- TOC entry 34 (OID 494529)
-- Name: companies; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE companies FROM PUBLIC;
GRANT SELECT ON TABLE companies TO labstudent;
GRANT SELECT,UPDATE,DELETE ON TABLE companies TO webserv;
GRANT ALL ON TABLE companies TO tcarr;
GRANT SELECT ON TABLE companies TO vfrith;


--
-- TOC entry 35 (OID 494535)
-- Name: portfoliomanagers; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE portfoliomanagers (
    mid character varying(10) NOT NULL,
    managername character varying(255),
    degree character varying(255),
    haslogedin boolean,
    firstlogin timestamp with time zone,
    lastlogin timestamp with time zone,
    logincount integer,
    emailadress character varying(255),
    disabled boolean DEFAULT false,
    disableddate timestamp with time zone,
    uctdegree character varying(7),
    email character varying(255)
);


--
-- TOC entry 36 (OID 494535)
-- Name: portfoliomanagers; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE portfoliomanagers FROM PUBLIC;
GRANT SELECT ON TABLE portfoliomanagers TO labstudent;
GRANT INSERT,SELECT,UPDATE,DELETE ON TABLE portfoliomanagers TO webserv;
GRANT ALL ON TABLE portfoliomanagers TO tcarr;
GRANT SELECT ON TABLE portfoliomanagers TO vfrith;


--
-- TOC entry 37 (OID 494538)
-- Name: portfolios; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE portfolios (
    mid character varying(10) NOT NULL,
    cid integer DEFAULT 0 NOT NULL,
    quantity integer DEFAULT 0
);


--
-- TOC entry 38 (OID 494538)
-- Name: portfolios; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE portfolios FROM PUBLIC;
GRANT SELECT ON TABLE portfolios TO labstudent;
GRANT SELECT ON TABLE portfolios TO webserv;
GRANT ALL ON TABLE portfolios TO tcarr;
GRANT SELECT ON TABLE portfolios TO vfrith;


--
-- TOC entry 39 (OID 494542)
-- Name: trades; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE trades (
    tid integer DEFAULT nextval('trades_tid_seq'::text) NOT NULL,
    mid character varying(10),
    tradetype character varying(50),
    tradequantity integer DEFAULT 0,
    cid integer DEFAULT 0,
    motivation text,
    tradecommitted boolean DEFAULT false,
    tradetimestamp timestamp with time zone DEFAULT now(),
    confirmation character varying(255),
    tradecommitedtime timestamp with time zone,
    sharedate date,
    shareprice double precision
);


--
-- TOC entry 40 (OID 494542)
-- Name: trades; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE trades FROM PUBLIC;
GRANT SELECT ON TABLE trades TO labstudent;
GRANT ALL ON TABLE trades TO webserv;
GRANT ALL ON TABLE trades TO tcarr;
GRANT SELECT ON TABLE trades TO vfrith;


--
-- TOC entry 41 (OID 494552)
-- Name: importlog; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE importlog (
    importindex integer DEFAULT nextval('importlog_importindex_seq'::text) NOT NULL,
    timestamp1 timestamp with time zone,
    success boolean,
    reason character varying(50)
);


--
-- TOC entry 42 (OID 494552)
-- Name: importlog; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE importlog FROM PUBLIC;
GRANT SELECT ON TABLE importlog TO labstudent;
GRANT ALL ON TABLE importlog TO tcarr;
GRANT SELECT ON TABLE importlog TO vfrith;


--
-- TOC entry 43 (OID 494555)
-- Name: indexvalues; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE indexvalues (
    id integer DEFAULT nextval('indexvalues_id_seq'::text) NOT NULL,
    index_code character varying(10) NOT NULL,
    index_name character varying(50) NOT NULL,
    equity_code character varying(10) NOT NULL,
    weight double precision,
    price double precision,
    product double precision,
    old_base double precision,
    new_market_cap double precision,
    old_market_cap double precision,
    new_base double precision,
    index_value double precision,
    weight1 double precision,
    weight2 double precision,
    dateofindex date,
    timestamp1 timestamp with time zone
);


--
-- TOC entry 44 (OID 494555)
-- Name: indexvalues; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE indexvalues FROM PUBLIC;
GRANT SELECT ON TABLE indexvalues TO labstudent;
GRANT ALL ON TABLE indexvalues TO tcarr;
GRANT SELECT ON TABLE indexvalues TO vfrith;


--
-- TOC entry 45 (OID 494558)
-- Name: pgadmin_desc; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE pgadmin_desc (
    objoid oid,
    description text
);


--
-- TOC entry 46 (OID 494558)
-- Name: pgadmin_desc; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_desc FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_desc TO tcarr;


--
-- TOC entry 47 (OID 494563)
-- Name: msysconf; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE msysconf (
    config integer NOT NULL,
    chvalue character varying(255),
    nvalue integer,
    comments character varying(255)
);


--
-- TOC entry 48 (OID 494563)
-- Name: msysconf; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE msysconf FROM PUBLIC;
GRANT SELECT ON TABLE msysconf TO labstudent;
GRANT ALL ON TABLE msysconf TO tcarr;
GRANT SELECT ON TABLE msysconf TO vfrith;


--
-- TOC entry 49 (OID 494565)
-- Name: trades_temp; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE trades_temp (
    tid integer,
    mid character varying(10),
    tradetype character varying(50),
    tradequantity integer,
    balance numeric(20,4),
    cid integer,
    tradetimestamp timestamp with time zone,
    ruling_price integer
);


--
-- TOC entry 50 (OID 494565)
-- Name: trades_temp; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE trades_temp FROM PUBLIC;
GRANT SELECT ON TABLE trades_temp TO labstudent;
GRANT ALL ON TABLE trades_temp TO tcarr;
GRANT SELECT ON TABLE trades_temp TO vfrith;


--
-- TOC entry 51 (OID 494567)
-- Name: groups_share_link; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE groups_share_link (
    group_id integer NOT NULL,
    cid integer NOT NULL
);


--
-- TOC entry 52 (OID 494567)
-- Name: groups_share_link; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE groups_share_link FROM PUBLIC;
GRANT SELECT ON TABLE groups_share_link TO labstudent;
GRANT SELECT ON TABLE groups_share_link TO webserv;
GRANT ALL ON TABLE groups_share_link TO tcarr;
GRANT SELECT ON TABLE groups_share_link TO vfrith;


--
-- TOC entry 53 (OID 494569)
-- Name: tblgroups; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE tblgroups (
    tblgroup_name character varying(50) NOT NULL,
    tblgroups_id integer
);


--
-- TOC entry 54 (OID 494569)
-- Name: tblgroups; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE tblgroups FROM PUBLIC;
GRANT SELECT ON TABLE tblgroups TO labstudent;
GRANT SELECT ON TABLE tblgroups TO webserv;
GRANT ALL ON TABLE tblgroups TO tcarr;
GRANT SELECT ON TABLE tblgroups TO vfrith;


--
-- TOC entry 55 (OID 494571)
-- Name: manager_grps_link; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE manager_grps_link (
    mid character varying(10) NOT NULL,
    group_id integer NOT NULL
);


--
-- TOC entry 56 (OID 494571)
-- Name: manager_grps_link; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE manager_grps_link FROM PUBLIC;
GRANT SELECT ON TABLE manager_grps_link TO labstudent;
GRANT INSERT,SELECT ON TABLE manager_grps_link TO webserv;
GRANT ALL ON TABLE manager_grps_link TO tcarr;
GRANT SELECT ON TABLE manager_grps_link TO vfrith;


\connect - root

SET search_path = public, pg_catalog;

--
-- TOC entry 57 (OID 494573)
-- Name: commodities_fix; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE commodities_fix (
    commodity_id integer DEFAULT nextval('commodities_fi_commodity_id_seq'::text) NOT NULL,
    commodity character varying(20),
    am_fix numeric(30,6),
    pm_fix numeric(30,6),
    fix_date date,
    record_stamp timestamp with time zone
);


--
-- TOC entry 58 (OID 494573)
-- Name: commodities_fix; Type: ACL; Schema: public; Owner: root
--

REVOKE ALL ON TABLE commodities_fix FROM PUBLIC;
GRANT SELECT ON TABLE commodities_fix TO labstudent;
GRANT ALL ON TABLE commodities_fix TO tcarr;
GRANT SELECT ON TABLE commodities_fix TO vfrith;


--
-- TOC entry 59 (OID 494576)
-- Name: exchange_rate; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE exchange_rate (
    zar_usd numeric(30,6),
    usd_zar numeric(30,6),
    rate_date date NOT NULL,
    ratetimestamp timestamp with time zone DEFAULT now(),
    rate_id integer
);


--
-- TOC entry 60 (OID 494576)
-- Name: exchange_rate; Type: ACL; Schema: public; Owner: root
--

REVOKE ALL ON TABLE exchange_rate FROM PUBLIC;
GRANT SELECT ON TABLE exchange_rate TO labstudent;
GRANT SELECT ON TABLE exchange_rate TO webserv;
GRANT ALL ON TABLE exchange_rate TO tcarr;
GRANT SELECT ON TABLE exchange_rate TO vfrith;


\connect - dhorwitz

SET search_path = public, pg_catalog;

--
-- TOC entry 61 (OID 494581)
-- Name: comm_max_date; Type: VIEW; Schema: public; Owner: dhorwitz
--

CREATE VIEW comm_max_date AS
    SELECT max(commodities_fix.fix_date) AS max FROM commodities_fix;


--
-- TOC entry 62 (OID 494581)
-- Name: comm_max_date; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE comm_max_date FROM PUBLIC;


--
-- TOC entry 63 (OID 494582)
-- Name: wealth_daily; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE wealth_daily (
    mid character varying(10) NOT NULL,
    name character varying(50),
    wealth integer,
    date_run date NOT NULL
);


--
-- TOC entry 64 (OID 494582)
-- Name: wealth_daily; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE wealth_daily FROM PUBLIC;
GRANT SELECT ON TABLE wealth_daily TO labstudent;
GRANT SELECT ON TABLE wealth_daily TO webserv;
GRANT ALL ON TABLE wealth_daily TO tcarr;
GRANT SELECT ON TABLE wealth_daily TO vfrith;


--
-- TOC entry 65 (OID 494584)
-- Name: pgadmin_param; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE pgadmin_param (
    param_id integer,
    param_value text,
    param_desc text
);


--
-- TOC entry 66 (OID 494584)
-- Name: pgadmin_param; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_param FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_param TO PUBLIC;
GRANT ALL ON TABLE pgadmin_param TO tcarr;


--
-- TOC entry 67 (OID 494589)
-- Name: pgadmin_rev_log; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE pgadmin_rev_log (
    event_timestamp timestamp with time zone DEFAULT now(),
    username text,
    "version" real,
    query text
);


--
-- TOC entry 68 (OID 494589)
-- Name: pgadmin_rev_log; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_rev_log FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_rev_log TO PUBLIC;
GRANT ALL ON TABLE pgadmin_rev_log TO tcarr;


--
-- TOC entry 69 (OID 494595)
-- Name: closingprices; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE closingprices (
    id integer DEFAULT nextval('closingprices_id_seq'::text) NOT NULL,
    inserttimestamp date NOT NULL,
    projectname character varying(50),
    alpha_code character varying(5) NOT NULL,
    isin_code character varying(20),
    name character varying(50),
    ruling_price integer DEFAULT 0,
    high integer DEFAULT 0,
    low integer DEFAULT 0,
    last_sale integer DEFAULT 0,
    volume integer DEFAULT 0,
    status character varying(50),
    cid integer DEFAULT 0,
    importid integer,
    peratio real,
    divyield real,
    earnyield real,
    volumetraded integer,
    imported timestamp with time zone DEFAULT now()
);


--
-- TOC entry 70 (OID 494595)
-- Name: closingprices; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE closingprices FROM PUBLIC;
GRANT SELECT ON TABLE closingprices TO labstudent;
GRANT SELECT ON TABLE closingprices TO webserv;
GRANT ALL ON TABLE closingprices TO tcarr;
GRANT SELECT ON TABLE closingprices TO vfrith;


--
-- TOC entry 71 (OID 494605)
-- Name: movers; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE movers (
    cid integer NOT NULL,
    most_recent integer,
    last_week integer,
    last_month date,
    last_month1 integer,
    last_year integer
);


--
-- TOC entry 72 (OID 494605)
-- Name: movers; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE movers FROM PUBLIC;
GRANT SELECT ON TABLE movers TO labstudent;
GRANT SELECT ON TABLE movers TO webserv;
GRANT ALL ON TABLE movers TO tcarr;
GRANT SELECT ON TABLE movers TO vfrith;


--
-- TOC entry 73 (OID 494607)
-- Name: settings; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE settings (
    startingbalance integer
);


--
-- TOC entry 74 (OID 494607)
-- Name: settings; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE settings FROM PUBLIC;
GRANT SELECT ON TABLE settings TO labstudent;
GRANT SELECT ON TABLE settings TO webserv;
GRANT ALL ON TABLE settings TO tcarr;
GRANT SELECT ON TABLE settings TO vfrith;


--
-- TOC entry 136 (OID 494609)
-- Name: creatuser (character, character); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION creatuser (character, character) RETURNS integer
    AS 'insert into portfoliomanagers values ($1,$2);
insert into bankaccounts values ($1,(select startingbalance from settings));
select 1 as result;'
    LANGUAGE sql;


--
-- TOC entry 137 (OID 494609)
-- Name: creatuser (character, character); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION creatuser (character, character) FROM PUBLIC;
GRANT ALL ON FUNCTION creatuser (character, character) TO PUBLIC;
REVOKE ALL ON FUNCTION creatuser (character, character) FROM dhorwitz;


--
-- TOC entry 138 (OID 494610)
-- Name: creatuser (text, text); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION creatuser (text, text) RETURNS integer
    AS 'insert into portfoliomanagers values ($1,$2);
insert into bankaccounts values ($1,(select startingbalance from settings));
select 1 as result;'
    LANGUAGE sql;


--
-- TOC entry 139 (OID 494610)
-- Name: creatuser (text, text); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION creatuser (text, text) FROM PUBLIC;
GRANT ALL ON FUNCTION creatuser (text, text) TO PUBLIC;
REVOKE ALL ON FUNCTION creatuser (text, text) FROM dhorwitz;


--
-- TOC entry 140 (OID 494611)
-- Name: createuser (text, text); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION "createuser" (text, text) RETURNS integer
    AS 'insert into portfoliomanagers values ($1,$2);
insert into bankaccounts values ($1,(select startingbalance from settings));
select 1 as result;'
    LANGUAGE sql;


--
-- TOC entry 141 (OID 494611)
-- Name: createuser (text, text); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION "createuser" (text, text) FROM PUBLIC;
GRANT ALL ON FUNCTION "createuser" (text, text) TO PUBLIC;
REVOKE ALL ON FUNCTION "createuser" (text, text) FROM dhorwitz;


--
-- TOC entry 18 (OID 494612)
-- Name: divpayouts_payoutid_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE divpayouts_payoutid_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 19 (OID 494612)
-- Name: divpayouts_payoutid_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE divpayouts_payoutid_seq FROM PUBLIC;
GRANT UPDATE ON TABLE divpayouts_payoutid_seq TO tcarr;


--
-- TOC entry 75 (OID 494614)
-- Name: divpayouts; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE divpayouts (
    payoutid integer DEFAULT nextval('divpayouts_payoutid_seq'::text) NOT NULL,
    dateofpayout date NOT NULL,
    proportion real,
    used boolean DEFAULT false
);


--
-- TOC entry 76 (OID 494614)
-- Name: divpayouts; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE divpayouts FROM PUBLIC;
GRANT SELECT ON TABLE divpayouts TO labstudent;
GRANT ALL ON TABLE divpayouts TO tcarr;
GRANT SELECT ON TABLE divpayouts TO vfrith;


--
-- TOC entry 77 (OID 494618)
-- Name: pgadmin_seq_cache; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE pgadmin_seq_cache (
    sequence_oid oid,
    sequence_last_value integer,
    sequence_increment_by integer,
    sequence_max_value integer,
    sequence_min_value integer,
    sequence_cache_value integer,
    sequence_is_cycled text,
    sequence_timestamp timestamp with time zone DEFAULT now()
);


--
-- TOC entry 78 (OID 494618)
-- Name: pgadmin_seq_cache; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_seq_cache FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_seq_cache TO PUBLIC;
GRANT ALL ON TABLE pgadmin_seq_cache TO tcarr;


--
-- TOC entry 79 (OID 494624)
-- Name: pgadmin_table_cache; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE pgadmin_table_cache (
    table_oid oid,
    table_rows integer,
    table_timestamp timestamp with time zone DEFAULT now()
);


--
-- TOC entry 80 (OID 494624)
-- Name: pgadmin_table_cache; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_table_cache FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_table_cache TO PUBLIC;
GRANT ALL ON TABLE pgadmin_table_cache TO tcarr;


--
-- TOC entry 142 (OID 494627)
-- Name: pgadmin_get_desc (oid); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION pgadmin_get_desc (oid) RETURNS text
    AS 'SELECT description FROM pgadmin_desc WHERE objoid = $1'
    LANGUAGE sql;


--
-- TOC entry 143 (OID 494627)
-- Name: pgadmin_get_desc (oid); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION pgadmin_get_desc (oid) FROM PUBLIC;
GRANT ALL ON FUNCTION pgadmin_get_desc (oid) TO PUBLIC;
REVOKE ALL ON FUNCTION pgadmin_get_desc (oid) FROM dhorwitz;


--
-- TOC entry 144 (OID 494628)
-- Name: pgadmin_get_pgdesc (oid); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION pgadmin_get_pgdesc (oid) RETURNS text
    AS 'SELECT description FROM pg_description WHERE objoid = $1'
    LANGUAGE sql;


--
-- TOC entry 145 (OID 494628)
-- Name: pgadmin_get_pgdesc (oid); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION pgadmin_get_pgdesc (oid) FROM PUBLIC;
GRANT ALL ON FUNCTION pgadmin_get_pgdesc (oid) TO PUBLIC;
REVOKE ALL ON FUNCTION pgadmin_get_pgdesc (oid) FROM dhorwitz;


--
-- TOC entry 146 (OID 494629)
-- Name: pgadmin_get_col_def (oid, integer); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION pgadmin_get_col_def (oid, integer) RETURNS text
    AS 'SELECT adsrc FROM pg_attrdef WHERE adrelid = $1 AND adnum = $2'
    LANGUAGE sql;


--
-- TOC entry 147 (OID 494629)
-- Name: pgadmin_get_col_def (oid, integer); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION pgadmin_get_col_def (oid, integer) FROM PUBLIC;
GRANT ALL ON FUNCTION pgadmin_get_col_def (oid, integer) TO PUBLIC;
REVOKE ALL ON FUNCTION pgadmin_get_col_def (oid, integer) FROM dhorwitz;


--
-- TOC entry 148 (OID 494630)
-- Name: pgadmin_get_handler (oid); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION pgadmin_get_handler (oid) RETURNS text
    AS 'SELECT proname::text FROM pg_proc WHERE oid = $1'
    LANGUAGE sql;


--
-- TOC entry 149 (OID 494630)
-- Name: pgadmin_get_handler (oid); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION pgadmin_get_handler (oid) FROM PUBLIC;
GRANT ALL ON FUNCTION pgadmin_get_handler (oid) TO PUBLIC;
REVOKE ALL ON FUNCTION pgadmin_get_handler (oid) FROM dhorwitz;


--
-- TOC entry 150 (OID 494631)
-- Name: pgadmin_get_type (oid); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION pgadmin_get_type (oid) RETURNS text
    AS 'SELECT typname::text FROM pg_type WHERE oid = $1'
    LANGUAGE sql;


--
-- TOC entry 151 (OID 494631)
-- Name: pgadmin_get_type (oid); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION pgadmin_get_type (oid) FROM PUBLIC;
GRANT ALL ON FUNCTION pgadmin_get_type (oid) TO PUBLIC;
REVOKE ALL ON FUNCTION pgadmin_get_type (oid) FROM dhorwitz;


--
-- TOC entry 152 (OID 494632)
-- Name: pgadmin_get_rows (oid); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION pgadmin_get_rows (oid) RETURNS pgadmin_table_cache
    AS 'SELECT DISTINCT ON(table_oid) * FROM pgadmin_table_cache WHERE table_oid = $1 ORDER BY table_oid, table_timestamp DESC'
    LANGUAGE sql;


--
-- TOC entry 153 (OID 494632)
-- Name: pgadmin_get_rows (oid); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION pgadmin_get_rows (oid) FROM PUBLIC;
GRANT ALL ON FUNCTION pgadmin_get_rows (oid) TO PUBLIC;
REVOKE ALL ON FUNCTION pgadmin_get_rows (oid) FROM dhorwitz;


--
-- TOC entry 154 (OID 494633)
-- Name: pgadmin_get_sequence (oid); Type: FUNCTION; Schema: public; Owner: dhorwitz
--

CREATE FUNCTION pgadmin_get_sequence (oid) RETURNS pgadmin_seq_cache
    AS 'SELECT DISTINCT ON(sequence_oid) * FROM pgadmin_seq_cache WHERE sequence_oid = $1 ORDER BY sequence_oid, sequence_timestamp DESC'
    LANGUAGE sql;


--
-- TOC entry 155 (OID 494633)
-- Name: pgadmin_get_sequence (oid); Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON FUNCTION pgadmin_get_sequence (oid) FROM PUBLIC;
GRANT ALL ON FUNCTION pgadmin_get_sequence (oid) TO PUBLIC;
REVOKE ALL ON FUNCTION pgadmin_get_sequence (oid) FROM dhorwitz;


--
-- TOC entry 81 (OID 494636)
-- Name: pgadmin_databases; Type: VIEW; Schema: public; Owner: dhorwitz
--

CREATE VIEW pgadmin_databases AS
    SELECT d.oid AS database_oid, d.datname AS database_name, d.datpath AS database_path, pg_get_userbyid(d.datdba) AS database_owner, CASE WHEN (d.oid <= (18655)::oid) THEN pgadmin_get_pgdesc(d.oid) ELSE pgadmin_get_desc(d.oid) END AS database_comments FROM pg_database d;


--
-- TOC entry 82 (OID 494636)
-- Name: pgadmin_databases; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_databases FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_databases TO PUBLIC;


--
-- TOC entry 83 (OID 494639)
-- Name: pgadmin_functions; Type: VIEW; Schema: public; Owner: dhorwitz
--

CREATE VIEW pgadmin_functions AS
    SELECT p.oid AS function_oid, p.proname AS function_name, pg_get_userbyid(p.proowner) AS function_owner, rtrim(btrim((((((((((((((((CASE WHEN (pgadmin_get_type(p.proargtypes[0]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[0]) || ', '::text) ELSE ''::text END || CASE WHEN (pgadmin_get_type(p.proargtypes[1]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[1]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[2]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[2]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[3]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[3]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[4]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[4]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[5]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[5]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[6]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[6]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[7]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[7]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[8]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[8]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[9]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[9]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[10]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[10]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[11]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[11]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[12]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[12]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[13]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[13]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[14]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[14]) || ', '::text) ELSE ''::text END) || CASE WHEN (pgadmin_get_type(p.proargtypes[15]) IS NOT NULL) THEN (pgadmin_get_type(p.proargtypes[15]) || ', '::text) ELSE ''::text END)), ','::text) AS function_arguments, pgadmin_get_type(p.prorettype) AS function_returns, p.prosrc AS function_source, l.lanname AS function_language, CASE WHEN (p.oid <= (18655)::oid) THEN pgadmin_get_pgdesc(p.oid) ELSE pgadmin_get_desc(p.oid) END AS function_comments FROM pg_proc p, pg_language l WHERE (p.prolang = l.oid);


--
-- TOC entry 84 (OID 494639)
-- Name: pgadmin_functions; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_functions FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_functions TO PUBLIC;


--
-- TOC entry 85 (OID 494643)
-- Name: pgadmin_sequences; Type: VIEW; Schema: public; Owner: dhorwitz
--

CREATE VIEW pgadmin_sequences AS
    SELECT c.oid AS sequence_oid, c.relname AS sequence_name, pg_get_userbyid(c.relowner) AS sequence_owner, c.relacl AS sequence_acl, pgadmin_get_sequence(c.oid) AS sequence_last_value, pgadmin_get_sequence(c.oid) AS sequence_increment_by, pgadmin_get_sequence(c.oid) AS sequence_max_value, pgadmin_get_sequence(c.oid) AS sequence_min_value, pgadmin_get_sequence(c.oid) AS sequence_cache_value, pgadmin_get_sequence(c.oid) AS sequence_is_cycled, CASE WHEN (c.oid <= (18655)::oid) THEN pgadmin_get_pgdesc(c.oid) ELSE pgadmin_get_desc(c.oid) END AS sequence_comments FROM pg_class c WHERE (c.relkind = 'S'::"char");


--
-- TOC entry 86 (OID 494643)
-- Name: pgadmin_sequences; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_sequences FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_sequences TO PUBLIC;


--
-- TOC entry 87 (OID 494646)
-- Name: pgadmin_triggers; Type: VIEW; Schema: public; Owner: dhorwitz
--

CREATE VIEW pgadmin_triggers AS
    SELECT t.oid AS trigger_oid, t.tgname AS trigger_name, c.relname AS trigger_table, p.proname AS trigger_function, t.tgtype AS trigger_type, CASE WHEN (t.oid <= (18655)::oid) THEN pgadmin_get_pgdesc(t.oid) ELSE pgadmin_get_desc(t.oid) END AS trigger_comments FROM pg_trigger t, pg_class c, pg_proc p WHERE ((c.oid = t.tgrelid) AND (p.oid = t.tgfoid));


--
-- TOC entry 88 (OID 494646)
-- Name: pgadmin_triggers; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_triggers FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_triggers TO PUBLIC;


--
-- TOC entry 89 (OID 494649)
-- Name: pgadmin_views; Type: VIEW; Schema: public; Owner: dhorwitz
--

CREATE VIEW pgadmin_views AS
    SELECT c.oid AS view_oid, c.relname AS view_name, pg_get_userbyid(c.relowner) AS view_owner, c.relacl AS view_acl, pg_get_viewdef((c.relname)::text) AS view_definition, CASE WHEN (c.oid <= (18655)::oid) THEN pgadmin_get_pgdesc(c.oid) ELSE pgadmin_get_desc(c.oid) END AS view_comments FROM pg_class c WHERE ((c.relhasrules AND (EXISTS (SELECT r.rulename FROM pg_rewrite r WHERE ((r.ev_class = c.oid) AND (bpchar(r.ev_type) = '1'::bpchar))))) OR (c.relkind = 'v'::"char"));


--
-- TOC entry 90 (OID 494649)
-- Name: pgadmin_views; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE pgadmin_views FROM PUBLIC;
GRANT ALL ON TABLE pgadmin_views TO PUBLIC;


--
-- TOC entry 20 (OID 494650)
-- Name: sector_sectorid_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE sector_sectorid_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 21 (OID 494650)
-- Name: sector_sectorid_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE sector_sectorid_seq FROM PUBLIC;
GRANT UPDATE ON TABLE sector_sectorid_seq TO tcarr;


--
-- TOC entry 91 (OID 494652)
-- Name: sector; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE sector (
    sectorid integer DEFAULT nextval('sector_sectorid_seq'::text) NOT NULL,
    sectorname character varying(100) NOT NULL,
    sharenetcode integer
);


--
-- TOC entry 92 (OID 494652)
-- Name: sector; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE sector FROM PUBLIC;
GRANT SELECT ON TABLE sector TO webserv;
GRANT ALL ON TABLE sector TO tcarr;


--
-- TOC entry 22 (OID 494655)
-- Name: cpi_cpiindex_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE cpi_cpiindex_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 23 (OID 494655)
-- Name: cpi_cpiindex_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE cpi_cpiindex_seq FROM PUBLIC;
GRANT UPDATE ON TABLE cpi_cpiindex_seq TO tcarr;


--
-- TOC entry 93 (OID 494657)
-- Name: cpi; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE cpi (
    cpiindex integer DEFAULT nextval('cpi_cpiindex_seq'::text) NOT NULL,
    cpimonth date NOT NULL,
    cpiindexvalue real,
    anualchange real,
    monthlychange real
);


--
-- TOC entry 94 (OID 494657)
-- Name: cpi; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE cpi FROM PUBLIC;
GRANT ALL ON TABLE cpi TO tcarr;


--
-- TOC entry 24 (OID 494660)
-- Name: sectors_sectorid_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE sectors_sectorid_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 25 (OID 494660)
-- Name: sectors_sectorid_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE sectors_sectorid_seq FROM PUBLIC;
GRANT UPDATE ON TABLE sectors_sectorid_seq TO tcarr;


--
-- TOC entry 26 (OID 494662)
-- Name: sharestraded_sharestradeid_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE sharestraded_sharestradeid_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 27 (OID 494662)
-- Name: sharestraded_sharestradeid_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE sharestraded_sharestradeid_seq FROM PUBLIC;
GRANT UPDATE ON TABLE sharestraded_sharestradeid_seq TO tcarr;


--
-- TOC entry 28 (OID 494664)
-- Name: courses_courseid_seq; Type: SEQUENCE; Schema: public; Owner: dhorwitz
--

CREATE SEQUENCE courses_courseid_seq
    START 1
    INCREMENT 1
    MAXVALUE 2147483647
    MINVALUE 1
    CACHE 1;


--
-- TOC entry 29 (OID 494664)
-- Name: courses_courseid_seq; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE courses_courseid_seq FROM PUBLIC;
GRANT UPDATE ON TABLE courses_courseid_seq TO tcarr;


--
-- TOC entry 95 (OID 494666)
-- Name: courses; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE courses (
    courseid integer DEFAULT nextval('courses_courseid_seq'::text) NOT NULL,
    coursename character varying(50),
    coursecode character varying(7) NOT NULL
);


--
-- TOC entry 96 (OID 494666)
-- Name: courses; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE courses FROM PUBLIC;
GRANT SELECT ON TABLE courses TO webserv;
GRANT ALL ON TABLE courses TO tcarr;


--
-- TOC entry 97 (OID 494669)
-- Name: managerscourses; Type: TABLE; Schema: public; Owner: dhorwitz
--

CREATE TABLE managerscourses (
    mid character varying(20) NOT NULL,
    courseid integer NOT NULL
);


--
-- TOC entry 98 (OID 494669)
-- Name: managerscourses; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE managerscourses FROM PUBLIC;
GRANT INSERT,SELECT ON TABLE managerscourses TO webserv;
GRANT ALL ON TABLE managerscourses TO tcarr;


\connect - tcarr

SET search_path = public, pg_catalog;

--
-- TOC entry 30 (OID 494846)
-- Name: attachments_seq; Type: SEQUENCE; Schema: public; Owner: tcarr
--

CREATE SEQUENCE attachments_seq
    START 1
    INCREMENT 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    CACHE 1;


\connect - dhorwitz

SET search_path = public, pg_catalog;

--
-- TOC entry 99 (OID 2198660)
-- Name: avg_wealth_daily; Type: VIEW; Schema: public; Owner: dhorwitz
--

CREATE VIEW avg_wealth_daily AS
    SELECT wealth_daily.date_run, avg(wealth_daily.wealth) AS avg FROM wealth_daily GROUP BY wealth_daily.date_run;


--
-- TOC entry 100 (OID 2198660)
-- Name: avg_wealth_daily; Type: ACL; Schema: public; Owner: dhorwitz
--

REVOKE ALL ON TABLE avg_wealth_daily FROM PUBLIC;
GRANT SELECT ON TABLE avg_wealth_daily TO webserv;


--
-- TOC entry 101 (OID 584672)
-- Name: bankaccounts_bid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX bankaccounts_bid_idx ON bankaccounts USING btree (mid);


--
-- TOC entry 103 (OID 584673)
-- Name: companies_cid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX companies_cid_idx ON companies USING btree (cid);


--
-- TOC entry 104 (OID 584674)
-- Name: companies_companycode_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX companies_companycode_idx ON companies USING btree (companycode);


--
-- TOC entry 105 (OID 584675)
-- Name: companies_exchange_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX companies_exchange_idx ON companies USING btree (exchangename);


--
-- TOC entry 108 (OID 584676)
-- Name: portfolios_cid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX portfolios_cid_idx ON portfolios USING btree (cid);


--
-- TOC entry 109 (OID 584677)
-- Name: portfolios_mid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX portfolios_mid_idx ON portfolios USING btree (mid);


--
-- TOC entry 113 (OID 584678)
-- Name: trades_tid_key; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE UNIQUE INDEX trades_tid_key ON trades USING btree (tid);


--
-- TOC entry 112 (OID 584679)
-- Name: trades_tid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX trades_tid_idx ON trades USING btree (tid);


--
-- TOC entry 114 (OID 584680)
-- Name: trades_tradescid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX trades_tradescid_idx ON trades USING btree (cid);


--
-- TOC entry 115 (OID 584681)
-- Name: trades_tradesmid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX trades_tradesmid_idx ON trades USING btree (mid);


--
-- TOC entry 111 (OID 584682)
-- Name: trades_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX trades_idx ON trades USING btree (tradetimestamp);


--
-- TOC entry 125 (OID 584683)
-- Name: closingprices_cid_idx; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE INDEX closingprices_cid_idx ON closingprices USING btree (cid);


--
-- TOC entry 126 (OID 584684)
-- Name: movers_cid_key; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE UNIQUE INDEX movers_cid_key ON movers USING btree (cid);


--
-- TOC entry 127 (OID 584685)
-- Name: divpayouts_payoutid_key; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE UNIQUE INDEX divpayouts_payoutid_key ON divpayouts USING btree (payoutid);


--
-- TOC entry 130 (OID 584686)
-- Name: sector_sectorid_key; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE UNIQUE INDEX sector_sectorid_key ON sector USING btree (sectorid);


--
-- TOC entry 131 (OID 584687)
-- Name: cpi_cpiindex_key; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE UNIQUE INDEX cpi_cpiindex_key ON cpi USING btree (cpiindex);


--
-- TOC entry 133 (OID 584688)
-- Name: courses_courseid_key; Type: INDEX; Schema: public; Owner: dhorwitz
--

CREATE UNIQUE INDEX courses_courseid_key ON courses USING btree (courseid);


--
-- TOC entry 102 (OID 584721)
-- Name: bankaccounts_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY bankaccounts
    ADD CONSTRAINT bankaccounts_pkey PRIMARY KEY (mid);


--
-- TOC entry 106 (OID 584723)
-- Name: companies_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY companies
    ADD CONSTRAINT companies_pkey PRIMARY KEY (cid);


--
-- TOC entry 107 (OID 584725)
-- Name: portfoliomanagers_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY portfoliomanagers
    ADD CONSTRAINT portfoliomanagers_pkey PRIMARY KEY (mid);


--
-- TOC entry 110 (OID 584727)
-- Name: portfolios_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY portfolios
    ADD CONSTRAINT portfolios_pkey PRIMARY KEY (mid, cid);


--
-- TOC entry 116 (OID 584729)
-- Name: importlog_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY importlog
    ADD CONSTRAINT importlog_pkey PRIMARY KEY (importindex);


--
-- TOC entry 117 (OID 584731)
-- Name: indexvalues_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY indexvalues
    ADD CONSTRAINT indexvalues_pkey PRIMARY KEY (id);


--
-- TOC entry 118 (OID 584733)
-- Name: groups_share_link_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY groups_share_link
    ADD CONSTRAINT groups_share_link_pkey PRIMARY KEY (group_id, cid);


--
-- TOC entry 119 (OID 584735)
-- Name: tblgroups_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY tblgroups
    ADD CONSTRAINT tblgroups_pkey PRIMARY KEY (tblgroup_name);


--
-- TOC entry 120 (OID 584737)
-- Name: manager_grps_link_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY manager_grps_link
    ADD CONSTRAINT manager_grps_link_pkey PRIMARY KEY (mid, group_id);


\connect - root

SET search_path = public, pg_catalog;

--
-- TOC entry 121 (OID 584739)
-- Name: commodities_fix_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY commodities_fix
    ADD CONSTRAINT commodities_fix_pkey PRIMARY KEY (commodity_id);


--
-- TOC entry 122 (OID 584741)
-- Name: exchange_rate_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY exchange_rate
    ADD CONSTRAINT exchange_rate_pkey PRIMARY KEY (rate_date);


\connect - dhorwitz

SET search_path = public, pg_catalog;

--
-- TOC entry 123 (OID 584743)
-- Name: wealth_daily_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY wealth_daily
    ADD CONSTRAINT wealth_daily_pkey PRIMARY KEY (mid, date_run);


--
-- TOC entry 124 (OID 584745)
-- Name: closingprices2_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY closingprices
    ADD CONSTRAINT closingprices2_pkey PRIMARY KEY (alpha_code, inserttimestamp);


--
-- TOC entry 128 (OID 584747)
-- Name: divpayouts_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY divpayouts
    ADD CONSTRAINT divpayouts_pkey PRIMARY KEY (dateofpayout);


--
-- TOC entry 129 (OID 584749)
-- Name: sector_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY sector
    ADD CONSTRAINT sector_pkey PRIMARY KEY (sectorname);


--
-- TOC entry 132 (OID 584751)
-- Name: cpi_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY cpi
    ADD CONSTRAINT cpi_pkey PRIMARY KEY (cpimonth);


--
-- TOC entry 134 (OID 584753)
-- Name: courses_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (coursecode);


--
-- TOC entry 135 (OID 584755)
-- Name: managerscourses_pkey; Type: CONSTRAINT; Schema: public; Owner: dhorwitz
--

ALTER TABLE ONLY managerscourses
    ADD CONSTRAINT managerscourses_pkey PRIMARY KEY (mid, courseid);


--
-- TOC entry 156 (OID 584777)
-- Name: RI_ConstraintTrigger_584777; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER INSERT OR UPDATE ON bankaccounts
    FROM portfoliomanagers
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_check_ins" ('portfoliomanagers_mid', 'bankaccounts', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 157 (OID 584778)
-- Name: RI_ConstraintTrigger_584778; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER companies_cid
    AFTER DELETE ON companies
    FROM portfolios
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_del" ('companies_cid', 'portfolios', 'companies', 'FULL', 'cid', 'cid');


--
-- TOC entry 158 (OID 584779)
-- Name: RI_ConstraintTrigger_584779; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER companies_cid
    AFTER UPDATE ON companies
    FROM portfolios
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_upd" ('companies_cid', 'portfolios', 'companies', 'FULL', 'cid', 'cid');


--
-- TOC entry 159 (OID 584780)
-- Name: RI_ConstraintTrigger_584780; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER companies_cid
    AFTER DELETE ON companies
    FROM trades
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_del" ('companies_cid', 'trades', 'companies', 'FULL', 'cid', 'cid');


--
-- TOC entry 160 (OID 584781)
-- Name: RI_ConstraintTrigger_584781; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER companies_cid
    AFTER UPDATE ON companies
    FROM trades
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_upd" ('companies_cid', 'trades', 'companies', 'FULL', 'cid', 'cid');


--
-- TOC entry 161 (OID 584782)
-- Name: RI_ConstraintTrigger_584782; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER DELETE ON portfoliomanagers
    FROM bankaccounts
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_cascade_del" ('portfoliomanagers_mid', 'bankaccounts', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 162 (OID 584783)
-- Name: RI_ConstraintTrigger_584783; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER UPDATE ON portfoliomanagers
    FROM bankaccounts
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_cascade_upd" ('portfoliomanagers_mid', 'bankaccounts', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 163 (OID 584784)
-- Name: RI_ConstraintTrigger_584784; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER DELETE ON portfoliomanagers
    FROM portfolios
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_del" ('portfoliomanagers_mid', 'portfolios', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 164 (OID 584785)
-- Name: RI_ConstraintTrigger_584785; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER UPDATE ON portfoliomanagers
    FROM portfolios
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_upd" ('portfoliomanagers_mid', 'portfolios', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 165 (OID 584786)
-- Name: RI_ConstraintTrigger_584786; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER DELETE ON portfoliomanagers
    FROM trades
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_del" ('portfoliomanagers_mid', 'trades', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 166 (OID 584787)
-- Name: RI_ConstraintTrigger_584787; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER UPDATE ON portfoliomanagers
    FROM trades
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_noaction_upd" ('portfoliomanagers_mid', 'trades', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 167 (OID 584788)
-- Name: RI_ConstraintTrigger_584788; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER companies_cid
    AFTER INSERT OR UPDATE ON portfolios
    FROM companies
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_check_ins" ('companies_cid', 'portfolios', 'companies', 'FULL', 'cid', 'cid');


--
-- TOC entry 168 (OID 584789)
-- Name: RI_ConstraintTrigger_584789; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER INSERT OR UPDATE ON portfolios
    FROM portfoliomanagers
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_check_ins" ('portfoliomanagers_mid', 'portfolios', 'portfoliomanagers', 'FULL', 'mid', 'mid');


--
-- TOC entry 169 (OID 584790)
-- Name: RI_ConstraintTrigger_584790; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER companies_cid
    AFTER INSERT OR UPDATE ON trades
    FROM companies
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_check_ins" ('companies_cid', 'trades', 'companies', 'FULL', 'cid', 'cid');


--
-- TOC entry 170 (OID 584791)
-- Name: RI_ConstraintTrigger_584791; Type: TRIGGER; Schema: public; Owner: dhorwitz
--

CREATE CONSTRAINT TRIGGER portfoliomanagers_mid
    AFTER INSERT OR UPDATE ON trades
    FROM portfoliomanagers
    NOT DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE "RI_FKey_check_ins" ('portfoliomanagers_mid', 'trades', 'portfoliomanagers', 'FULL', 'mid', 'mid');


