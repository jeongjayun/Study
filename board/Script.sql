-- board_table
 drop table if exists board_table;

CREATE SEQUENCE system.board_table_seq
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 9999
	NOCYCLE
	NOCACHE
	NOORDER;

CREATE TABLE board_table (
    id NUMBER PRIMARY KEY,
    boardTitle VARCHAR2(50),
    boardWriter VARCHAR2(20),
    boardPass VARCHAR2(20),
    boardContents VARCHAR2(500),
    boardHits NUMBER DEFAULT 0,
    createdAt TIMESTAMP DEFAULT SYSTIMESTAMP,
    fileAttached NUMBER DEFAULT 0
);

SELECT * FROM board_table

SELECT  id,
		boardTitle,
		boardWriter,
		boardHits,
		to_char(createdAt, 'yyyy-MM-dd') AS createdAt
FROM    board_table
ORDER BY createdAt DESC
