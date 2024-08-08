-- https://leetcode.com/problems/students-and-examinations/

select s.student_id, s.student_name, sub.subject_name, count(e.subject_name) as attended_exams
from Students s
         cross join Subjects sub
         left join Examinations e
                   on s.student_id = e.student_id AND sub.subject_name = e.subject_name
group by s.student_id, s.student_name, sub.subject_name
order by s.student_id, sub.subject_name

SELECT s.student_id, s.student_name, sub.subject_name, COALESCE(e.attended_exams, 0) AS attended_exams
FROM Students s
         CROSS JOIN Subjects sub
         LEFT JOIN (
    SELECT student_id, subject_name, COUNT(*) AS attended_exams
    FROM Examinations
    GROUP BY student_id, subject_name
) e ON s.student_id = e.student_id AND sub.subject_name = e.subject_name
ORDER BY s.student_id, sub.subject_name;