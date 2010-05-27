CREATE TABLE  "MAJORTASK" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(40), 
	 CONSTRAINT "MAJORTASK_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "USERS" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"NAME_SURNAME" VARCHAR2(50), 
	"ROLE" VARCHAR2(20), 
	"PASSWORD" VARCHAR2(20), 
	 CONSTRAINT "USERS_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "ASSIGNMENT" 
   (	"USER_ID" NUMBER NOT NULL ENABLE, 
	"MAJORTASK_ID" NUMBER NOT NULL ENABLE, 
	"PRIORITY" CHAR(1) NOT NULL ENABLE, 
	 CONSTRAINT "ASSIGNMENT_PK" PRIMARY KEY ("USER_ID", "MAJORTASK_ID") ENABLE, 
	 CONSTRAINT "ASSIGNMENT_CON" FOREIGN KEY ("USER_ID")
	  REFERENCES  "USERS" ("ID") ENABLE, 
	 CONSTRAINT "ASSIGNMENT_CON_MAJORTASK" FOREIGN KEY ("MAJORTASK_ID")
	  REFERENCES  "MAJORTASK" ("ID") ENABLE
   );

CREATE TABLE  "PROJECT" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(50), 
	"OBJECTIVE" VARCHAR2(50), 
	"LEADER" NUMBER NOT NULL ENABLE, 
	"START_DATE" DATE, 
	"FINISH_DATE" DATE, 
	 CONSTRAINT "PROJECT_PK" PRIMARY KEY ("ID") ENABLE, 
	 CONSTRAINT "PROJECT_FK" FOREIGN KEY ("LEADER")
	  REFERENCES  "USERS" ("ID") ENABLE
   );

CREATE TABLE  "SUMMARY" 
   (	"ID" NUMBER, 
	"COMMENT" VARCHAR2(400), 
	"SUMMARY_DATE" DATE, 
	 CONSTRAINT "SUMMARY_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "COMMENTED" 
   (	"SUMMARY_ID" NUMBER NOT NULL ENABLE, 
	"PROJECT_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "COMMENTED_PK" PRIMARY KEY ("SUMMARY_ID", "PROJECT_ID") ENABLE, 
	 CONSTRAINT "COMMENTED_CON" FOREIGN KEY ("SUMMARY_ID")
	  REFERENCES  "SUMMARY" ("ID") ENABLE, 
	 CONSTRAINT "COMMENTED_CON_PROJECT" FOREIGN KEY ("PROJECT_ID")
	  REFERENCES  "PROJECT" ("ID") ENABLE
   );

CREATE TABLE  "OBJECTIVE" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(50), 
	 CONSTRAINT "OBJECTIVE_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "CONSISTOF" 
   (	"PROJECT_ID" NUMBER NOT NULL ENABLE, 
	"OBJECTIVE_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "CONSISTOF_PK" PRIMARY KEY ("PROJECT_ID", "OBJECTIVE_ID") ENABLE, 
	 CONSTRAINT "CONSISTOF_CON_PROJECT" FOREIGN KEY ("PROJECT_ID")
	  REFERENCES  "PROJECT" ("ID") ENABLE, 
	 CONSTRAINT "CONSISTOF_CON_OBJECTIVE" FOREIGN KEY ("OBJECTIVE_ID")
	  REFERENCES  "OBJECTIVE" ("ID") ENABLE
   );

CREATE TABLE  "COST" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"EXPENSE" NUMBER, 
	"COLOR" VARCHAR2(10), 
	"BUDGET" NUMBER, 
	 CONSTRAINT "COST_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "SUBJECTIVETASK" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(50), 
	 CONSTRAINT "SUBJECTIVETASK_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "HASSUBJECTIVE" 
   (	"OBJECTIVE_ID" NUMBER NOT NULL ENABLE, 
	"SUBJECTIVETASK_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "HASSUBJECTIVE_PK" PRIMARY KEY ("OBJECTIVE_ID", "SUBJECTIVETASK_ID") ENABLE, 
	 CONSTRAINT "HASSUBJECTIVE_CON_OBJECTIVE" FOREIGN KEY ("OBJECTIVE_ID")
	  REFERENCES  "OBJECTIVE" ("ID") ENABLE, 
	 CONSTRAINT "HASSUBJECTIVE_CON_ST" FOREIGN KEY ("SUBJECTIVETASK_ID")
	  REFERENCES  "SUBJECTIVETASK" ("ID") ENABLE
   );

CREATE TABLE  "HASTASK" 
   (	"OBJECTIVE_ID" NUMBER NOT NULL ENABLE, 
	"MAJORTASK_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "HASTASK_PK" PRIMARY KEY ("OBJECTIVE_ID", "MAJORTASK_ID") ENABLE, 
	 CONSTRAINT "HASTASK_CON_OBJECTIVE" FOREIGN KEY ("OBJECTIVE_ID")
	  REFERENCES  "OBJECTIVE" ("ID") ENABLE, 
	 CONSTRAINT "HASTASK_CON_MT" FOREIGN KEY ("MAJORTASK_ID")
	  REFERENCES  "MAJORTASK" ("ID") ENABLE
   );

CREATE TABLE  "MAJORSLICE" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"COMPLETED" NUMBER, 
	"VERIFIED" NUMBER, 
	"MAJORSLICE_DATE" DATE, 
	 CONSTRAINT "MAJORSLICE_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "MT_HAS" 
   (	"MAJORTASK_ID" NUMBER NOT NULL ENABLE, 
	"MAJORSLICE_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "MT_HAS_PK" PRIMARY KEY ("MAJORTASK_ID", "MAJORSLICE_ID") ENABLE, 
	 CONSTRAINT "MT_HAS_CON_MT" FOREIGN KEY ("MAJORTASK_ID")
	  REFERENCES  "MAJORTASK" ("ID") ENABLE, 
	 CONSTRAINT "MT_HAS_CON_MS" FOREIGN KEY ("MAJORSLICE_ID")
	  REFERENCES  "MAJORSLICE" ("ID") ENABLE
   );

CREATE TABLE  "PROJECT_HAS" 
   (	"PROJECT_ID" NUMBER NOT NULL ENABLE, 
	"COST_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "PROJECT_HAS_PK" PRIMARY KEY ("PROJECT_ID", "COST_ID") ENABLE, 
	 CONSTRAINT "PROJECT_HAS_CON_PROJECT" FOREIGN KEY ("PROJECT_ID")
	  REFERENCES  "PROJECT" ("ID") ENABLE, 
	 CONSTRAINT "PROJECT_HAS_CON_COST" FOREIGN KEY ("COST_ID")
	  REFERENCES  "COST" ("ID") ENABLE
   );

CREATE TABLE  "SUBJECTIVESLICE" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"SUBJECTIVESLICE_DATE" DATE, 
	"COLOR" VARCHAR2(20), 
	 CONSTRAINT "SUBJECTIVESLICE_PK" PRIMARY KEY ("ID") ENABLE
   );

CREATE TABLE  "ST_HAS" 
   (	"SUBJECTIVETASK_ID" NUMBER NOT NULL ENABLE, 
	"SUBJECTIVESLICE_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "ST_HAS_PK" PRIMARY KEY ("SUBJECTIVETASK_ID", "SUBJECTIVESLICE_ID") ENABLE, 
	 CONSTRAINT "ST_HAS_CON_ST" FOREIGN KEY ("SUBJECTIVETASK_ID")
	  REFERENCES  "SUBJECTIVETASK" ("ID") ENABLE, 
	 CONSTRAINT "ST_HAS_CON_SS" FOREIGN KEY ("SUBJECTIVESLICE_ID")
	  REFERENCES  "SUBJECTIVESLICE" ("ID") ENABLE
   );

CREATE TABLE  "WORKSON" 
   (	"PROJECT_ID" NUMBER NOT NULL ENABLE, 
	"USER_ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "WORKSON_PK" PRIMARY KEY ("PROJECT_ID", "USER_ID") ENABLE, 
	 CONSTRAINT "WORKSON_CON_PROJECT" FOREIGN KEY ("PROJECT_ID")
	  REFERENCES  "PROJECT" ("ID") ENABLE, 
	 CONSTRAINT "WORKSON_CON_USER" FOREIGN KEY ("USER_ID")
	  REFERENCES  "USERS" ("ID") ENABLE
   );


CREATE UNIQUE INDEX  "ASSIGNMENT_PK" ON  "ASSIGNMENT" ("USER_ID", "MAJORTASK_ID");

CREATE UNIQUE INDEX  "COMMENTED_PK" ON  "COMMENTED" ("SUMMARY_ID", "PROJECT_ID");

CREATE UNIQUE INDEX  "CONSISTOF_PK" ON  "CONSISTOF" ("PROJECT_ID", "OBJECTIVE_ID");

CREATE UNIQUE INDEX  "COST_PK" ON  "COST" ("ID");

CREATE UNIQUE INDEX  "HASSUBJECTIVE_PK" ON  "HASSUBJECTIVE" ("OBJECTIVE_ID", "SUBJECTIVETASK_ID");

CREATE UNIQUE INDEX  "HASTASK_PK" ON  "HASTASK" ("OBJECTIVE_ID", "MAJORTASK_ID");

CREATE UNIQUE INDEX  "MAJORSLICE_PK" ON  "MAJORSLICE" ("ID");

CREATE UNIQUE INDEX  "MAJORTASK_PK" ON  "MAJORTASK" ("ID");

CREATE UNIQUE INDEX  "MT_HAS_PK" ON  "MT_HAS" ("MAJORTASK_ID", "MAJORSLICE_ID");

CREATE UNIQUE INDEX  "OBJECTIVE_PK" ON  "OBJECTIVE" ("ID");

CREATE UNIQUE INDEX  "PROJECT_HAS_PK" ON  "PROJECT_HAS" ("PROJECT_ID", "COST_ID");

CREATE UNIQUE INDEX  "PROJECT_PK" ON  "PROJECT" ("ID");

CREATE UNIQUE INDEX  "ST_HAS_PK" ON  "ST_HAS" ("SUBJECTIVETASK_ID", "SUBJECTIVESLICE_ID");

CREATE UNIQUE INDEX  "SUBJECTIVESLICE_PK" ON  "SUBJECTIVESLICE" ("ID");

CREATE UNIQUE INDEX  "SUBJECTIVETASK_PK" ON  "SUBJECTIVETASK" ("ID");

CREATE UNIQUE INDEX  "SUMMARY_PK" ON  "SUMMARY" ("ID");

CREATE UNIQUE INDEX  "USERS_PK" ON  "USERS" ("ID");

CREATE UNIQUE INDEX  "WORKSON_PK" ON  "WORKSON" ("PROJECT_ID", "USER_ID");