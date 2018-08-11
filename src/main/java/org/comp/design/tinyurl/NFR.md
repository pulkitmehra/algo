# Tiny URL shortening

## Requirements

* System is read heavy 1 write - 100 reads.

   * Total write per month 500 M
   * Total read per month(1:100) - 50 B
   * RPS = 50B / (30*24*60*60) = 20K rps
   * WPS = 500M /  (30*24*60*60) = 200 wps
   * Read/Write object size 500Bytes or .5KB
   * Upload Bandwidth = 200 WPS * .5KB = 100 KB/s
   * Donwload Bandwidth= 20K * .5KB = 10 MB/s
   * Storage per day = 200 * .5KB * 24 * 60 * 60 = 8GB per day
   * Storage per month= 8GB * 30 = 240GB
   * Storage per year= 240GB * 12 = 2TB
   * Retention persiod of 5 years = 2TB * 5 = 10TB
   * Cache via 80-20 rule: 
        * Request per day = 20K * 60 * 60 * 24 = 1.7 B
        * 20% cached = 345M cached
        * Cache memory = 345M * .5KB = 172 GB
     


