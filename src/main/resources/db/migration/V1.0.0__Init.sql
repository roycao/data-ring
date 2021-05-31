CREATE TABLE "DATA_CATALOG"(
    "ID" IDENTITY NOT NULL PRIMARY KEY,
    "NAME" VARCHAR(255) NOT NULL,
    "DESCRIPTION" VARCHAR(255)
);
ALTER TABLE DATA_CATALOG ADD CONSTRAINT UK_NAME UNIQUE("NAME");