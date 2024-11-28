CREATE TABLE domains (
                         domain_id INT AUTO_INCREMENT PRIMARY KEY,
                         program VARCHAR(255),
                         capacity INT,
                         qualification VARCHAR(255),
                         batch VARCHAR(255)
);

-- Create the `students` table
CREATE TABLE students (
                          student_id INT AUTO_INCREMENT PRIMARY KEY,
                          roll_number VARCHAR(50),
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          email VARCHAR(255),
                          photograph_path VARCHAR(255),
                          cgpa FLOAT,
                          total_credits INT,
                          graduation_year VARCHAR(50),
                          domain INT,
                          specialisation INT,
                          placement_id INT
);