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

-- Division 000-099: Computer science, information and general works
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

-- Division 100-199: Philosophy and psychology
('100', 'Philosophy and psychology', '100'),
('110', 'Metaphysics', '100'),
('120', 'Epistemology, causation and humankind', '100'),
('130', 'Paranormal phenomena', '100'),
('140', 'Specific philosophical schools', '100'),
('150', 'Psychology', '100'),
('160', 'Logic', '100'),
('170', 'Ethics (moral philosophy)', '100'),
('180', 'Ancient, medieval and eastern philosophy', '100'),
('190', 'Modern western philosophy', '100'),

-- Division 200-299: Religion
('200', 'Religion', '200'),
('210', 'Philosophy and theory of religion', '200'),
('220', 'Bible', '200'),
('230', 'Christianity, Christian theology', '200'),
('240', 'Christian moral and devotional theology', '200'),
('250', 'Christian orders and local Christian church', '200'),
('260', 'Christian social theology', '200'),
('270', 'History of Christianity and Christian denominations', '200'),
('280', 'Christian denominations and sects', '200'),
('290', 'Comparative religion and other religions', '200'),

-- Division 300-399: Social sciences
('300', 'Social sciences', '300'),
('310', 'Collections of general statistics', '300'),
('320', 'Political science', '300'),
('330', 'Economics', '300'),
('340', 'Law', '300'),
('350', 'Public administration and military science', '300'),
('360', 'Social problems and services, associations', '300'),
('370', 'Education', '300'),
('380', 'Commerce, communications and transportation', '300'),
('390', 'Customs, etiquette and folklore', '300'),

-- Division 400-499: Language
('400', 'Language', '400'),
('410', 'Linguistics', '400'),
('420', 'English and Old English', '400'),
('430', 'Germanic languages, German', '400'),
('440', 'Romance languages, French', '400'),
('450', 'Italian, Romanian and Rhaeto-Romanic', '400'),
('460', 'Spanish and Portuguese languages', '400'),
('470', 'Latin and other Italic languages', '400'),
('480', 'Hellenic languages, Classical Greek', '400'),
('490', 'Other languages', '400'),

-- Division 500-599: Pure sciences
('500', 'Pure sciences', '500'),
('510', 'Mathematics', '500'),
('520', 'Astronomy and allied sciences', '500'),
('530', 'Physics', '500'),
('540', 'Chemistry and allied sciences', '500'),
('550', 'Earth sciences', '500'),
('560', 'Paleontology, paleozoology', '500'),
('570', 'Life sciences, biology', '500'),
('580', 'Plants (botany)', '500'),
('590', 'Animals (zoology)', '500'),

-- Division 600-699: Technology (applied sciences)
('600', 'Technology (applied sciences)', '600'),
('610', 'Medicine and health', '600'),
('620', 'Engineering and allied operations', '600'),
('630', 'Agriculture and related technologies', '600'),
('640', 'Home economics and family living', '600'),
('650', 'Management and auxiliary services', '600'),
('660', 'Chemical engineering and related technologies', '600'),
('670', 'Manufacturing', '600'),
('680', 'Manufacture of products for specific uses', '600'),
('690', 'Buildings and construction', '600'),

-- Division 700-799: Arts, recreation and sports
('700', 'Arts, recreation and sports', '700'),
('710', 'Civic and landscape art', '700'),
('720', 'Architecture', '700'),
('730', 'Sculpture and related arts', '700'),
('740', 'Drawing and decorative arts', '700'),
('750', 'Painting and paintings', '700'),
('760', 'Graphic arts, printmaking and prints', '700'),
('770', 'Photography, digital imaging and computer art', '700'),
('780', 'Music', '700'),
('790', 'Recreational and performing arts', '700'),

-- Division 800-899: Literature
('800', 'Literature', '800'),
('810', 'American literature in English', '800'),
('820', 'English and Old English literatures', '800'),
('830', 'Literatures of Germanic languages', '800'),
('840', 'Literatures of Romance languages, French literature', '800'),
('850', 'Italian, Romanian and Rhaeto-Romanic literatures', '800'),
('860', 'Spanish and Portuguese literatures', '800'),
('870', 'Latin and other Italic literatures', '800'),
('880', 'Hellenic literatures, Classical Greek', '800'),
('890', 'Literatures of other languages', '800'),

-- Division 900-999: History and geography
('900', 'History and geography', '900'),
('910', 'Geography and travel', '900'),
('920', 'Biography, genealogy and insignia', '900'),
('930', 'History of ancient world to ca. 499', '900'),
('940', 'General history of Europe', '900'),
('950', 'General history of Asia', '900'),
('960', 'General history of Africa', '900'),
('970', 'General history of North America', '900'),
('980', 'General history of South America', '900'),
('990', 'General history of other areas', '900');

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

INSERT INTO dewey_category (code, name, division_code) VALUES
('050', 'General serial publications', '050'),
('051', 'Serials in American English', '050'),
('052', 'Serials in English', '050'),
('053', 'Serials in other Germanic languages', '050'),
('054', 'Serials in French, Occitan, and Catalan', '050'),
('055', 'Serials in Italian, Romanian, and related languages', '050'),
('056', 'Serials in Spanish and Portuguese', '050'),
('057', 'Serials in Slavic languages', '050'),
('058', 'Serials in Scandinavian languages', '050'),
('059', 'Serials in other languages', '050');

INSERT INTO dewey_category (code, name, division_code) VALUES
('060', 'General organizations and museum science', '060'),
('061', 'Organizations in North America', '060'),
('062', 'Organizations in British Isles; in England', '060'),
('063', 'Organizations in central Europe; in Germany', '060'),
('064', 'Organizations in France and Monaco', '060'),
('065', 'Organizations in Italy and adjacent islands', '060'),
('066', 'Organizations in Iberian Peninsula and adjacent islands', '060'),
('067', 'Organizations in eastern Europe; in Russia', '060'),
('068', 'Organizations in other geographic areas', '060'),
('069', 'Museum science', '060');

INSERT INTO dewey_category (code, name, division_code) VALUES
('070', 'News media, journalism, and publishing', '070'),
('071', 'Newspapers in North America', '070'),
('072', 'Newspapers in British Isles; in England', '070'),
('073', 'Newspapers in central Europe; in Germany', '070'),
('074', 'Newspapers in France and Monaco', '070'),
('075', 'Newspapers in Italy and adjacent islands', '070'),
('076', 'Newspapers in Iberian peninsula and adjacent islands', '070'),
('077', 'Newspapers in eastern Europe; in Russia', '070'),
('078', 'Newspapers in Scandinavia', '070'),
('079', 'Newspapers in other geographic areas', '070');

INSERT INTO dewey_category (code, name, division_code) VALUES
('080', 'Quotations', '080'),
('081', 'Quotations in American English', '080'),
('082', 'Quotations in English', '080'),
('083', 'Quotations in other Germanic languages', '080'),
('084', 'Quotations in French, Occitan, and Catalan', '080'),
('085', 'Quotations in Italian, Romanian, and related languages', '080'),
('086', 'Quotations in Spanish and Portuguese', '080'),
('087', 'Quotations in Slavic languages', '080'),
('088', 'Quotations in Scandinavian languages', '080'),
('089', 'Quotations in other languages', '080');

INSERT INTO dewey_category (code, name, division_code) VALUES
('090', 'Manuscripts and rare books', '090'),
('091', 'Manuscripts', '090'),
('092', 'Block books', '090'),
('093', 'Incunabula', '090'),
('094', 'Printed books', '090'),
('095', 'Books notable for bindings', '090'),
('096', 'Books notable for illustrations', '090'),
('097', 'Books notable for ownership or origin', '090'),
('098', 'Prohibited works, forgeries, and hoaxes', '090'),
('099', 'Books notable for format', '090');

-- 100-199: Philosophy and psychology
INSERT INTO dewey_category (code, name, division_code) VALUES
('100', 'Philosophy and psychology', '100'),
('101', 'Theory of philosophy', '100'),
('102', 'Miscellany of philosophy', '100'),
('103', 'Dictionaries, encyclopedias, concordances of philosophy', '100'),
('104', 'Special topics of philosophy', '100'),
('105', 'Serial publications of philosophy', '100'),
('106', 'Organizations and management of philosophy', '100'),
('107', 'Education, research, related topics of philosophy', '100'),
('108', 'Groups of people in philosophy', '100'),
('109', 'Historical treatment of philosophy', '100');

INSERT INTO dewey_category (code, name, division_code) VALUES
('110', 'Metaphysics', '110'),
('111', 'Ontology', '110'),
('113', 'Cosmology (Philosophy of nature)', '110'),
('114', 'Space', '110'),
('115', 'Time', '110'),
('116', 'Change', '110'),
('117', 'Structure', '110'),
('118', 'Force and energy', '110'),
('119', 'Number and quantity', '110');

INSERT INTO dewey_category (code, name, division_code) VALUES
('120', 'Epistemology, causation and humankind', '120'),
('121', 'Epistemology (Theory of knowledge)', '120'),
('122', 'Causation', '120'),
('123', 'Determinism and indeterminism', '120'),
('124', 'Teleology', '120'),
('126', 'The self', '120'),
('127', 'The unconscious and the subconscious', '120'),
('128', 'Humankind', '120'),
('129', 'Origin and destiny of individual souls', '120');

INSERT INTO dewey_category (code, name, division_code) VALUES
('130', 'Paranormal phenomena', '130'),
('131', 'Psychic phenomena', '130'),
('133', 'Parapsychology and occultism', '130'),
('135', 'Dreams and mysteries', '130'),
('137', 'Divinatory graphology', '130'),
('138', 'Physiognomy', '130'),
('139', 'Phrenology', '130');

INSERT INTO dewey_category (code, name, division_code) VALUES
('140', 'Specific philosophical schools', '140'),
('141', 'Idealism and related systems', '140'),
('142', 'Critical philosophy', '140'),
('143', 'Bergsonism and intuitionism', '140'),
('144', 'Humanism and related systems', '140'),
('145', 'Sensationalism', '140'),
('146', 'Naturalism and related systems', '140'),
('147', 'Pantheism and related systems', '140'),
('148', 'Dogmatism, eclecticism, and syncretic systems', '140'),
('149', 'Other philosophical systems', '140');

INSERT INTO dewey_category (code, name, division_code) VALUES
('150', 'Psychology', '150'),
('151', 'Philosophical psychology', '150'),
('152', 'Sensory perception, movement, emotions, physiological drives', '150'),
('153', 'Conscious mental processes and intelligence', '150'),
('154', 'Subconscious and altered states and processes', '150'),
('155', 'Differential and developmental psychology', '150'),
('156', 'Comparative psychology', '150'),
('158', 'Applied psychology', '150'),
('159', 'Mathematical psychology', '150');

INSERT INTO dewey_category (code, name, division_code) VALUES
('160', 'Logic', '160'),
('161', 'Induction', '160'),
('162', 'Deduction', '160'),
('165', 'Fallacies and sources of error', '160'),
('166', 'Syllogisms', '160'),
('167', 'Hypotheses', '160'),
('168', 'Argument and persuasion', '160'),
('169', 'Analogy', '160');

INSERT INTO dewey_category (code, name, division_code) VALUES
('170', 'Ethics (moral philosophy)', '170'),
('171', 'Ethical systems', '170'),
('172', 'Political ethics', '170'),
('173', 'Ethics of family relationships', '170'),
('174', 'Professional and occupational ethics', '170'),
('175', 'Ethics of recreation, leisure, public performances', '170'),
('176', 'Ethics of sex and reproduction', '170'),
('177', 'Ethics of social relations', '170'),
('178', 'Ethics of consumption', '170'),
('179', 'Other ethical norms', '170');

INSERT INTO dewey_category (code, name, division_code) VALUES
('180', 'Ancient, medieval and eastern philosophy', '180'),
('181', 'Eastern philosophy', '180'),
('182', 'Pre-Socratic Greek philosophies', '180'),
('183', 'Sophistic, Socratic, and related Greek philosophies', '180'),
('184', 'Platonic philosophy', '180'),
('185', 'Aristotelian philosophy', '180'),
('186', 'Skeptic and Neoplatonic philosophies', '180'),
('187', 'Epicurean philosophy', '180'),
('188', 'Stoic philosophy', '180'),
('189', 'Medieval western philosophy', '180');

INSERT INTO dewey_category (code, name, division_code) VALUES
('190', 'Modern western philosophy', '190'),
('191', 'United States and Canada', '190'),
('192', 'British Isles', '190'),
('193', 'Germany and Austria', '190'),
('194', 'France', '190'),
('195', 'Italy', '190'),
('196', 'Spain and Portugal', '190'),
('197', 'Russia and Finland', '190'),
('198', 'Scandinavia', '190'),
('199', 'Other geographic areas', '190');

-- 200-299: Religion
INSERT INTO dewey_category (code, name, division_code) VALUES
('200', 'Religion', '200'),
('201', 'Religious sociology and anthropology', '200'),
('202', 'Doctrines', '200'),
('203', 'Public worship and other practices', '200'),
('204', 'Religious experience, life, practice', '200'),
('205', 'Religious ethics', '200'),
('206', 'Leaders and organization', '200'),
('207', 'Missions and religious education', '200'),
('208', 'Sources', '200'),
('209', 'Sects and reform movements', '200');

INSERT INTO dewey_category (code, name, division_code) VALUES
('210', 'Philosophy and theory of religion', '210'),
('211', 'Concepts of God', '210'),
('212', 'Existence, knowability, attributes of God', '210'),
('213', 'Creation', '210'),
('214', 'Theodicy', '210'),
('215', 'Science and religion', '210'),
('218', 'Humankind', '210'),
('219', 'Not assigned or no longer used', '210');

INSERT INTO dewey_category (code, name, division_code) VALUES
('220', 'Bible', '220'),
('221', 'Old Testament', '220'),
('222', 'Historical books of Old Testament', '220'),
('223', 'Poetic books of Old Testament', '220'),
('224', 'Prophetic books of Old Testament', '220'),
('225', 'New Testament', '220'),
('226', 'Gospels and Acts', '220'),
('227', 'Epistles', '220'),
('228', 'Revelation (Apocalypse)', '220'),
('229', 'Apocrypha and pseudepigrapha', '220');

INSERT INTO dewey_category (code, name, division_code) VALUES
('230', 'Christianity, Christian theology', '230'),
('231', 'God, Trinity, Godhead', '230'),
('232', 'Jesus Christ and his family', '230'),
('233', 'Humankind', '230'),
('234', 'Salvation and grace', '230'),
('235', 'Spiritual beings', '230'),
('236', 'Eschatology', '230'),
('237', 'Not assigned or no longer used', '230'),
('238', 'Creeds and catechisms', '230'),
('239', 'Apologetics and polemics', '230');

INSERT INTO dewey_category (code, name, division_code) VALUES
('240', 'Christian moral and devotional theology', '240'),
('241', 'Christian ethics', '240'),
('242', 'Devotional literature', '240'),
('243', 'Evangelistic writings for individuals and families', '240'),
('246', 'Use of art in Christianity', '240'),
('247', 'Church furnishings and related articles', '240'),
('248', 'Christian experience, practice, life', '240'),
('249', 'Christian observances in family life', '240');

INSERT INTO dewey_category (code, name, division_code) VALUES
('250', 'Christian orders and local Christian church', '250'),
('251', 'Preaching (Homiletics)', '250'),
('252', 'Texts of sermons', '250'),
('253', 'Pastoral office and work (Pastoral theology)', '250'),
('254', 'Parish administration', '250'),
('255', 'Religious congregations and orders', '250'),
('259', 'Pastoral care of families, of specific groups of people', '250');

INSERT INTO dewey_category (code, name, division_code) VALUES
('260', 'Christian social theology', '260'),
('261', 'Social theology', '260'),
('262', 'Ecclesiology', '260'),
('263', 'Days, times, places of religious observance', '260'),
('264', 'Public worship', '260'),
('265', 'Sacraments, other rites and acts', '260'),
('266', 'Missions', '260'),
('267', 'Associations for religious work', '260'),
('268', 'Religious education', '260'),
('269', 'Spiritual renewal', '260');

INSERT INTO dewey_category (code, name, division_code) VALUES
('270', 'History of Christianity and Christian denominations', '270'),
('271', 'Religious congregations and orders in church history', '270'),
('272', 'Persecutions in church history', '270'),
('273', 'Doctrinal controversies and heresies in church history', '270'),
('274', 'Christianity in Europe', '270'),
('275', 'Christianity in Asia', '270'),
('276', 'Christianity in Africa', '270'),
('277', 'Christianity in North America', '270'),
('278', 'Christianity in South America', '270'),
('279', 'Christianity in other areas', '270');

INSERT INTO dewey_category (code, name, division_code) VALUES
('280', 'Christian denominations and sects', '280'),
('281', 'Early church and Eastern churches', '280'),
('282', 'Roman Catholic Church', '280'),
('283', 'Anglican churches', '280'),
('284', 'Protestants of Continental origin', '280'),
('285', 'Presbyterian churches', '280'),
('286', 'Baptist churches', '280'),
('287', 'Methodist churches', '280'),
('289', 'Other Christian denominations', '280');

INSERT INTO dewey_category (code, name, division_code) VALUES
('290', 'Comparative religion and other religions', '290'),
('291', 'Comparative religion', '290'),
('292', 'Classical religion (Greek and Roman religion)', '290'),
('293', 'Germanic religion', '290'),
('294', 'Religions of Indic origin', '290'),
('295', 'Zoroastrianism (Mazdaism, Parseeism)', '290'),
('296', 'Judaism', '290'),
('297', 'Islam, Babism, Bahai Faith', '290'),
('299', 'Other religions', '290');

-- 300-399: Social sciences
INSERT INTO dewey_category (code, name, division_code) VALUES
('300', 'Social sciences', '300'),
('301', 'Sociology and anthropology', '300'),
('302', 'Social interaction', '300'),
('303', 'Social processes', '300'),
('304', 'Factors affecting social behavior', '300'),
('305', 'Social groups', '300'),
('306', 'Culture and institutions', '300'),
('307', 'Communities', '300');

INSERT INTO dewey_category (code, name, division_code) VALUES
('310', 'Collections of general statistics', '310'),
('314', 'General statistics of Europe', '310'),
('315', 'General statistics of Asia', '310'),
('316', 'General statistics of Africa', '310'),
('317', 'General statistics of North America', '310'),
('318', 'General statistics of South America', '310'),
('319', 'General statistics of other areas', '310');

INSERT INTO dewey_category (code, name, division_code) VALUES
('320', 'Political science', '320'),
('321', 'Systems of governments and states', '320'),
('322', 'Relation of state to organized groups', '320'),
('323', 'Civil and political rights', '320'),
('324', 'The political process', '320'),
('325', 'International migration and colonization', '320'),
('326', 'Slavery and emancipation', '320'),
('327', 'International relations', '320'),
('328', 'The legislative process', '320'),
('329', 'Practical politics', '320');

INSERT INTO dewey_category (code, name, division_code) VALUES
('330', 'Economics', '330'),
('331', 'Labor economics', '330'),
('332', 'Financial economics', '330'),
('333', 'Economics of land and energy', '330'),
('334', 'Cooperatives', '330'),
('335', 'Socialism and related systems', '330'),
('336', 'Public finance', '330'),
('337', 'International economics', '330'),
('338', 'Production', '330'),
('339', 'Macroeconomics and related topics', '330');

INSERT INTO dewey_category (code, name, division_code) VALUES
('340', 'Law', '340'),
('341', 'Law of nations', '340'),
('342', 'Constitutional and administrative law', '340'),
('343', 'Military, defense, public property, public finance law', '340'),
('344', 'Labor, social service, education, cultural law', '340'),
('345', 'Criminal law', '340'),
('346', 'Private law', '340'),
('347', 'Procedure and courts', '340'),
('348', 'Laws, regulations, cases', '340'),
('349', 'Law of specific jurisdictions and areas', '340');

INSERT INTO dewey_category (code, name, division_code) VALUES
('350', 'Public administration and military science', '350'),
('351', 'Public administration', '350'),
('352', 'General considerations of public administration', '350'),
('353', 'Specific fields of public administration', '350'),
('354', 'Administration of economy and environment', '350'),
('355', 'Military science', '350'),
('356', 'Infantry forces and warfare', '350'),
('357', 'Mounted forces and warfare', '350'),
('358', 'Air and other specialized forces and warfare', '350'),
('359', 'Sea (Naval) forces and warfare', '350');

INSERT INTO dewey_category (code, name, division_code) VALUES
('360', 'Social problems and services, associations', '360'),
('361', 'Social problems and social welfare in general', '360'),
('362', 'Social welfare problems and services', '360'),
('363', 'Other social problems and services', '360'),
('364', 'Criminology', '360'),
('365', 'Penal and related institutions', '360'),
('366', 'Associations', '360'),
('367', 'General clubs', '360'),
('368', 'Insurance', '360'),
('369', 'Miscellaneous kinds of associations', '360');

INSERT INTO dewey_category (code, name, division_code) VALUES
('370', 'Education', '370'),
('371', 'Schools and their activities, special education', '370'),
('372', 'Primary education (Elementary education)', '370'),
('373', 'Secondary education', '370'),
('374', 'Adult education', '370'),
('375', 'Curricula', '370'),
('376', 'Education of women', '370'),
('377', 'Schools and religion', '370'),
('378', 'Higher education (Tertiary education)', '370'),
('379', 'Public policy issues in education', '370');

INSERT INTO dewey_category (code, name, division_code) VALUES
('380', 'Commerce, communications and transportation', '380'),
('381', 'Commerce (Trade)', '380'),
('382', 'International commerce (Foreign trade)', '380'),
('383', 'Postal communication', '380'),
('384', 'Communications, telecommunication', '380'),
('385', 'Railroad transportation', '380'),
('386', 'Inland waterway and ferry transportation', '380'),
('387', 'Water, air, space transportation', '380'),
('388', 'Transportation, ground transportation', '380'),
('389', 'Metrology and standardization', '380');

INSERT INTO dewey_category (code, name, division_code) VALUES
('390', 'Customs, etiquette and folklore', '390'),
('391', 'Costume and personal appearance', '390'),
('392', 'Customs of life cycle and domestic life', '390'),
('393', 'Death customs', '390'),
('394', 'General customs', '390'),
('395', 'Etiquette (Manners)', '390'),
('398', 'Folklore', '390'),
('399', 'Customs of war and diplomacy', '390');

-- 400-499: Language
INSERT INTO dewey_category (code, name, division_code) VALUES
('400', 'Language', '400'),
('401', 'Philosophy and theory of language', '400'),
('402', 'Miscellany of language', '400'),
('403', 'Dictionaries of language', '400'),
('404', 'Special topics of language', '400'),
('405', 'Serial publications of language', '400'),
('406', 'Organizations of language', '400'),
('407', 'Education, research, related topics of language', '400'),
('408', 'With respect to groups of people', '400'),
('409', 'Geographic and persons treatment of language', '400');

INSERT INTO dewey_category (code, name, division_code) VALUES
('410', 'Linguistics', '410'),
('411', 'Writing systems', '410'),
('412', 'Etymology', '410'),
('413', 'Dictionaries', '410'),
('414', 'Phonology and phonetics', '410'),
('415', 'Grammar', '410'),
('417', 'Dialectology and historical linguistics', '410'),
('418', 'Standard usage, applied linguistics', '410'),
('419', 'Sign languages', '410');

INSERT INTO dewey_category (code, name, division_code) VALUES
('420', 'English and Old English', '420'),
('421', 'English writing system and phonology', '420'),
('422', 'English etymology', '420'),
('423', 'English dictionaries', '420'),
('424', 'Not assigned or no longer used', '420'),
('425', 'English grammar', '420'),
('427', 'English language variations', '420'),
('428', 'Standard English usage', '420'),
('429', 'Old English (Anglo-Saxon)', '420');

INSERT INTO dewey_category (code, name, division_code) VALUES
('430', 'Germanic languages, German', '430'),
('431', 'German writing systems and phonology', '430'),
('432', 'German etymology', '430'),
('433', 'German dictionaries', '430'),
('434', 'Not assigned or no longer used', '430'),
('435', 'German grammar', '430'),
('437', 'German language variations', '430'),
('438', 'Standard German usage', '430'),
('439', 'Other Germanic languages', '430');

INSERT INTO dewey_category (code, name, division_code) VALUES
('440', 'Romance languages, French', '440'),
('441', 'French writing systems and phonology', '440'),
('442', 'French etymology', '440'),
('443', 'French dictionaries', '440'),
('445', 'French grammar', '440'),
('446', 'Not assigned or no longer used', '440'),
('447', 'French language variations', '440'),
('448', 'Standard French usage', '440'),
('449', 'Provençal and Catalan', '440');

INSERT INTO dewey_category (code, name, division_code) VALUES
('450', 'Italian, Romanian and Rhaeto-Romanic', '450'),
('451', 'Italian writing systems and phonology', '450'),
('452', 'Italian etymology', '450'),
('453', 'Italian dictionaries', '450'),
('454', 'Not assigned or no longer used', '450'),
('455', 'Italian grammar', '450'),
('457', 'Italian language variations', '450'),
('458', 'Standard Italian usage', '450'),
('459', 'Romanian and Rhaeto-Romanic', '450');

INSERT INTO dewey_category (code, name, division_code) VALUES
('460', 'Spanish and Portuguese languages', '460'),
('461', 'Spanish writing systems and phonology', '460'),
('462', 'Spanish etymology', '460'),
('463', 'Spanish dictionaries', '460'),
('465', 'Spanish grammar', '460'),
('467', 'Spanish language variations', '460'),
('468', 'Standard Spanish usage', '460'),
('469', 'Portuguese', '460');

INSERT INTO dewey_category (code, name, division_code) VALUES
('470', 'Latin and other Italic languages', '470'),
('471', 'Classical Latin writing and phonology', '470'),
('472', 'Classical Latin etymology', '470'),
('473', 'Classical Latin dictionaries', '470'),
('475', 'Classical Latin grammar', '470'),
('477', 'Old, postclassical, Vulgar Latin', '470'),
('478', 'Classical Latin usage', '470'),
('479', 'Other Italic languages', '470');

INSERT INTO dewey_category (code, name, division_code) VALUES
('480', 'Hellenic languages, Classical Greek', '480'),
('481', 'Classical Greek writing and phonology', '480'),
('482', 'Classical Greek etymology', '480'),
('483', 'Classical Greek dictionaries', '480'),
('485', 'Classical Greek grammar', '480'),
('487', 'Pre-Classical and post-Classical Greek', '480'),
('488', 'Classical Greek usage', '480'),
('489', 'Other Hellenic languages', '480');

INSERT INTO dewey_category (code, name, division_code) VALUES
('490', 'Other languages', '490'),
('491', 'East Indo-European and Celtic languages', '490'),
('492', 'Afro-Asiatic languages, Semitic languages', '490'),
('493', 'Non-Semitic Afro-Asiatic languages', '490'),
('494', 'Altaic, Uralic, Hyperborean, Dravidian', '490'),
('495', 'Languages of East and Southeast Asia', '490'),
('496', 'African languages', '490'),
('497', 'North American native languages', '490'),
('498', 'South American native languages', '490'),
('499', 'Austronesian and other languages', '490');

-- 500-599: Pure sciences
INSERT INTO dewey_category (code, name, division_code) VALUES
('500', 'Pure sciences', '500'),
('501', 'Philosophy and theory of sciences', '500'),
('502', 'Miscellany of sciences', '500'),
('503', 'Dictionaries of sciences', '500'),
('505', 'Serial publications of sciences', '500'),
('506', 'Organizations of sciences', '500'),
('507', 'Education, research, related topics of sciences', '500'),
('508', 'Natural history', '500'),
('509', 'Historical treatment of sciences', '500');

INSERT INTO dewey_category (code, name, division_code) VALUES
('510', 'Mathematics', '510'),
('511', 'General principles of mathematics', '510'),
('512', 'Algebra', '510'),
('513', 'Arithmetic', '510'),
('514', 'Topology', '510'),
('515', 'Analysis', '510'),
('516', 'Geometry', '510'),
('518', 'Numerical analysis', '510'),
('519', 'Probabilities and applied mathematics', '510');

INSERT INTO dewey_category (code, name, division_code) VALUES
('520', 'Astronomy and allied sciences', '520'),
('521', 'Celestial mechanics', '520'),
('522', 'Techniques, procedures, apparatus, equipment', '520'),
('523', 'Specific celestial bodies and phenomena', '520'),
('525', 'Earth (Astronomical geography)', '520'),
('526', 'Mathematical geography', '520'),
('527', 'Celestial navigation', '520'),
('528', 'Ephemerides', '520'),
('529', 'Chronology', '520');

INSERT INTO dewey_category (code, name, division_code) VALUES
('530', 'Physics', '530'),
('531', 'Classical mechanics, solid mechanics', '530'),
('532', 'Fluid mechanics, liquid mechanics', '530'),
('533', 'Pneumatics (Gas mechanics)', '530'),
('534', 'Sound and related vibrations', '530'),
('535', 'Light and related electromagnetic phenomena', '530'),
('536', 'Heat', '530'),
('537', 'Electricity and electronics', '530'),
('538', 'Magnetism', '530'),
('539', 'Modern physics', '530');

INSERT INTO dewey_category (code, name, division_code) VALUES
('540', 'Chemistry and allied sciences', '540'),
('541', 'Physical chemistry', '540'),
('542', 'Techniques, procedures, apparatus, equipment', '540'),
('543', 'Analytical chemistry', '540'),
('546', 'Inorganic chemistry', '540'),
('547', 'Organic chemistry', '540'),
('548', 'Crystallography', '540'),
('549', 'Mineralogy', '540');

INSERT INTO dewey_category (code, name, division_code) VALUES
('550', 'Earth sciences', '550'),
('551', 'Geology, hydrology, meteorology', '550'),
('552', 'Petrology', '550'),
('553', 'Economic geology', '550'),
('554', 'Earth sciences of Europe', '550'),
('555', 'Earth sciences of Asia', '550'),
('556', 'Earth sciences of Africa', '550'),
('557', 'Earth sciences of North America', '550'),
('558', 'Earth sciences of South America', '550'),
('559', 'Earth sciences of other areas', '550');

INSERT INTO dewey_category (code, name, division_code) VALUES
('560', 'Paleontology, paleozoology', '560'),
('561', 'Paleobotany, fossil microorganisms', '560'),
('562', 'Fossil invertebrates', '560'),
('563', 'Fossil marine and seashore invertebrates', '560'),
('564', 'Fossil mollusks', '560'),
('565', 'Fossil arthropods', '560'),
('566', 'Fossil chordates', '560'),
('567', 'Fossil cold-blooded vertebrates', '560'),
('568', 'Fossil birds', '560'),
('569', 'Fossil mammals', '560');

INSERT INTO dewey_category (code, name, division_code) VALUES
('570', 'Life sciences, biology', '570'),
('571', 'Physiology and related subjects', '570'),
('572', 'Biochemistry', '570'),
('573', 'Specific physiological systems in animals', '570'),
('575', 'Specific parts of and physiological systems in plants', '570'),
('576', 'Genetics and evolution', '570'),
('577', 'Ecology', '570'),
('578', 'Natural history of organisms', '570'),
('579', 'Microorganisms, fungi, algae', '570');






