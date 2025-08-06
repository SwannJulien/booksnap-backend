-- Class level: 0-10
INSERT INTO dewey_class (code, name) VALUES
('000', 'Computer science, information, and general works'),
('100', 'Philosophy and psychology'),
('200', 'Religion'),
('300', 'Social sciences'),
('400', 'Language'),
('500', 'Science'),
('600', 'Technology'),
('700', 'Arts and recreation'),
('800', 'Literature'),
('900', 'History and geography');

-- Division level: 0-100
INSERT INTO dewey_division (code, name, class_code) VALUES
('000', 'Computer science, knowledge, and systems', '000'),
('010', 'Bibliographies', '000'),
('020', 'Library and information sciences', '000'),
('030', 'Encyclopedias and books of facts', '000'),
('050', 'Magazines, journals and serials', '000'),
('060', 'Associations, organizations and museums', '000'),
('070', 'News media, journalism, and publishing', '000'),
('080', 'Quotations', '000'),
('090', 'Manuscripts and rare books', '000');

-- Category level: 0-1000
INSERT INTO dewey_category (code, name, division_code) VALUES
('000', 'Computer science, information and general works', '000'),
('001', 'Knowledge', '000'),
('002', 'The book (writing, libraries, and book-related topics)', '000'),
('003', 'Systems', '000'),
('004', 'Data processing and computer science', '000'),
('005', 'Computer programming, programs, and data', '000'),
('006', 'Special computer methods (e.g. AI, multimedia, VR)', '000');

INSERT INTO dewey_category (code, name, division_code) VALUES
('010', 'Bibliography', '010'),
('011', 'Bibliographies', '010'),
('012', 'Bibliographies of individuals', '010'),
('014', 'Bibliographies of anonymous and pseudonymous works', '010'),
('015', 'Bibliographies of works from specific places', '010'),
('016', 'Bibliographies of works on specific subjects', '010'),
('017', 'General subject catalogs', '010');

INSERT INTO dewey_category (code, name, division_code) VALUES
('020', 'Library and information sciences', '020'),
('021', 'Library relationships (with archives, information centers, etc.)', '020'),
('022', 'Administration of physical plant', '020'),
('023', 'Personnel management', '020'),
('025', 'Library operations', '020'),
('026', 'Libraries for specific subjects', '020'),
('027', 'General libraries', '020'),
('028', 'Reading and use of other information media', '020');

INSERT INTO dewey_category (code, name, division_code) VALUES
('030', 'General encyclopedic works', '030'),
('031', 'Encyclopedias in American English', '030'),
('032', 'Encyclopedias in English', '030'),
('033', 'Encyclopedias in other Germanic languages', '030'),
('034', 'Encyclopedias in French, Occitan, and Catalan', '030'),
('035', 'Encyclopedias in Italian, Romanian, and related languages', '030'),
('036', 'Encyclopedias in Spanish and Portuguese', '030'),
('037', 'Encyclopedias in Slavic languages', '030'),
('038', 'Encyclopedias in Scandinavian languages', '030'),
('039', 'Encyclopedias in other languages', '030');






