ALTER TABLE students
    ADD CONSTRAINT fk_students_domain
        FOREIGN KEY (domain) REFERENCES domains(domain_id);