SELECT * FROM guest WHERE GENDER = 'Female' ORDER BY first_name ASC LIMIT 1;
TRUNCATE guest CASCADE;
select * from guest g2;

truncate batch_job_execution cascade;
truncate batch_job_execution_context cascade;
truncate batch_job_execution_params cascade;
truncate batch_job_instance cascade;
truncate batch_step_execution cascade;
truncate batch_step_execution_context cascade;
select * from batch_job_execution ;