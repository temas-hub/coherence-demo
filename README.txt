Demo cluster which shows RTC client read/write scenario + POF serialization + eviction

1)CacheServer   //you can run 2 instances to support backups
com.examples.CacheServer
-Dtangosol.coherence.cacheconfig="cachesrv/example-config.xml"


2)ProxyServer
com.examples.CacheServer
-Dtangosol.coherence.cacheconfig="proxy/example-config.xml"
-Dtangosol.coherence.distributed.localstorage=false


3)RealTimeClient
com.examples.RealTimeClient
-Dtangosol.coherence.override="rtc/tangosol-coherence-override.xml"
-Dtangosol.coherence.cacheconfig="rtc/example-config.xml"
-Dtangosol.coherence.distributed.localstorage=false
