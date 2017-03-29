-- insert into Employee table
insert into dbo.employee (first_name, last_name, business_unit, division, dob, email, employment_status, gender, hired_date, job_family, job_title, marital_status, nationality, phone, retired_date, stream, suspended_date, grade, location) values ( 'John', 'Slamet', 'SWD', 'SE', '1980-01-01', 'test@gmail.com', 'P', 'M', '2010-01-01','Java', 'AP', 'M', 'Indonesia', '0856123456789',null, 'JWT', null, 'JP','Yogyakarta');

-- insert into Dependent table
insert into dbo.dependent(first_name, last_name, gender, type, dob, employee_id) values ('Dian','Sastro', 'F', 'W',null,1);

-- inser into GradeHistory table
insert into dbo.grade_history(grade, dev_stage, start_date, end_date, employee_id) values ('JP', 2, '2016-01-01', '2016-12-12',1);

--insert into Address table
insert into dbo.address(address, active_ind, employee_id) values ('Jl. Sidobali No 2, Yogyakarta', 1,1);

--insert into EmpHistory table
insert into dbo.emp_history(employer, job_desc, active_ind, start_date, end_date, employee_id) values ('PT. Mitrais', 'Designer, Frontend developer', 1, null, null,1);

--insert into Location table
insert into dbo.location(branch_office, relocation_start, relocation_end, employee_id) values ('Yogyakarta', null, null, 1);

--insert into LookupMaster table
insert into dbo.lookup_master(type, description) values ('MARITAL', 'Marital Status');
insert into dbo.lookup_master(type, description) values ('ERROR', 'Error');
insert into dbo.lookup_master(type, description) values ('GRADE', 'Grade');
insert into dbo.lookup_master(type, description) values ('GENDER', 'Gender');
insert into dbo.lookup_master(type, description) values ('NATION', 'Nationality');
insert into dbo.lookup_master(type, description) values ('EMPSTAT', 'Employment Status');
insert into dbo.lookup_master(type, description) values ('DEPTYPE', 'Dependents Type');
insert into dbo.lookup_master(type, description) values ('ACTIND', 'Active Indicator');
insert into dbo.lookup_master(type, description) values ('BUSUNIT', 'Business Unit');
insert into dbo.lookup_master(type, description) values ('DIV', 'Division');
insert into dbo.lookup_master(type, description) values ('JOBFAM', 'Job Family');
insert into dbo.lookup_master(type, description) values ('STREAM', 'Stream');
insert into dbo.lookup_master(type, description) values ('JOBTIT', 'Job Title');

--insert into Lookup table
insert into dbo.lookup(data_code, data_desc, data_type) values ('S', 'Single', 'MARITAL');
insert into dbo.lookup(data_code, data_desc, data_type) values ('M', 'Married', 'MARITAL');
insert into dbo.lookup(data_code, data_desc, data_type) values ('W', 'Widowed', 'MARITAL');

insert into dbo.lookup(data_code, data_desc, data_type) values ('0001', 'Input required', 'ERROR');

insert into dbo.lookup(data_code, data_desc, data_type) values ('JP', 'Junior Programmer', 'GRADE');
insert into dbo.lookup(data_code, data_desc, data_type) values ('PG', 'Programmer', 'GRADE');
insert into dbo.lookup(data_code, data_desc, data_type) values ('AP', 'Analyst Programmer', 'GRADE');
insert into dbo.lookup(data_code, data_desc, data_type) values ('AN', 'Analyst', 'GRADE');

insert into dbo.lookup(data_code, data_desc, data_type) values ('IDN', 'Indonesia', 'NATION');

insert into dbo.lookup(data_code, data_desc, data_type) values ('C', 'Contract', 'EMPSTAT');
insert into dbo.lookup(data_code, data_desc, data_type) values ('P', 'Permanent', 'EMPSTAT');

insert into dbo.lookup(data_code, data_desc, data_type) values ('W', 'Wife', 'DEPTYPE');
insert into dbo.lookup(data_code, data_desc, data_type) values ('H', 'Husband', 'DEPTYPE');
insert into dbo.lookup(data_code, data_desc, data_type) values ('C', 'Child', 'DEPTYPE');

insert into dbo.lookup(data_code, data_desc, data_type) values ('SWD', 'Software Developer', 'JOBFAM');

insert into dbo.lookup(data_code, data_desc, data_type) values ('JWT', 'Java Web Technology', 'STREAM');

insert into dbo.lookup(data_code, data_desc, data_type) values ('M', 'Male', 'GENDER');
insert into dbo.lookup(data_code, data_desc, data_type) values ('F', 'Female', 'GENDER');