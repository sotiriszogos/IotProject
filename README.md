# PhMeter for Wine Making
## Σκοπός του project ήταν η κατασκευή ενός συστήματος μέτρησης του Ph ενός διαλύματος και εκτύπωση των αποτελεσμάτων στον φυλλομετρητή.
### Σ' αυτό το repository υπάρχουν οι ακόλουθοι 4 φάκελοι.
#### 1) Data Analysis apk : 
Περιέχει όλο τον κώδικα για την δημιουργία της android εφαρμογής η οποία υπολογίζει την το συνολικό resolution
range (σε bits), το συνολικό datarate range (σε bps), την κατανάλωση ισχύος για την Analog to Digital μετατροπή των δεδομένων, όπως 
επίσης και την συνολική κατανάλωση ισχύος της iot συσκευής σύμφωνα πάντα με τις τιμές στο βιβλίο "Enabling the internet of things".
#### 2) MatLab Analysis :
Περιέχει δύο συναρτήσεις (υλοποιημένες σε MatLab) που μοντελοποιούν τα διαγράμματα στο βιβλίο "Enabling the internet of things" που 
αφορούν την διάρκεια ζωής των μπαταριών σε σχέση με την μέση κατανάλωση ισχύος μιας iot συσκευής.
#### 3) Mbed Code :
Περιλαμβάνει το .cpp αρχείο που τρέχει πάνω στον microcontroller.
#### 4) RestFulApi : 
Περιέχει όλο τον κώδικα για την επικοινωνία του microcontroller με την βάση δεδομένων (για την αποθήκευση και την 
ανάγνωση των δεδομένων) και τον web server. 
#### Επίσης υπάρχει το report του project σε μορφή .doc και .pdf.