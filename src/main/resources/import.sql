INSERT INTO service_of_bank (name) VALUES ('openHoursIndividual'), ('openHours')
ON CONFLICT (name) DO NOTHING;